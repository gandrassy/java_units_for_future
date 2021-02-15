
// na most szállj el nekem runtime exceptionnal, te nyavalyás file kezelés!

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnmappableCharacterException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextFile {

  private Path theFile;

  private final Charset[] charsets = {StandardCharsets.UTF_8, Charset.forName("ISO-8859-2"),
      Charset.forName("Cp1250"), Charset.forName("MacCentralEurope"), Charset.forName("IBM852"),
      StandardCharsets.UTF_16, StandardCharsets.UTF_16BE, StandardCharsets.UTF_16LE};

  private Charset fileCharset = StandardCharsets.UTF_8; //ez a default, de a loadFile() felülírhatja!

  public TextFile(String fileName) {
    this.theFile = Paths.get(fileName);
    try {
      Files.createFile(theFile);
    } catch (FileAlreadyExistsException ignore) {
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void overwrite(List<String> contents) {
    try {
      Files.write(theFile, contents, fileCharset);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public List<String> load() {
    List<String> lines = new ArrayList<>();
    for (Charset charset : charsets) {
      boolean success = true;
      try {
        lines = Files.readAllLines(theFile, charset);
      } catch (MalformedInputException e) {
        success = false;
      } catch (IOException e) {
        e.printStackTrace();
      }
      if (success) {
        fileCharset = charset;
        break;
      }
    }
    return lines;
  }

  private void appendToFile(List<String> toAppend) {
    try {
      Files.write(theFile, toAppend, fileCharset, StandardOpenOption.APPEND);
    } catch (UnmappableCharacterException ignore) {
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void append(String content) {
    appendToFile(Collections.singletonList(content));
  }

  public void append(List<String> contents) {
    appendToFile(contents);
  }

  public Charset getCharset() {
    return fileCharset;
  }

  public void setCharsets(Charset charset) {
    this.fileCharset = charset;
  }

}
