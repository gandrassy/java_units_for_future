import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class ReactiveQueue<T, I> {

	
	private final Set<I> idsInQueue;
	private final Sinks.Many<T> sink;
	private final Flux<T> flux;
	private final Function<T, I> idExtractor;
	
	public ReactiveQueue(Function<T, I> idExtractor) {
		this.idsInQueue = new HashSet<>();
		this.sink = Sinks.many().multicast().onBackpressureBuffer();
		this.flux = sink.asFlux();
		this.idExtractor = idExtractor;
	}
	
	public Mono<void> offer(T item) {
		I id = idExtractor.apply(item);
		if (idsInQueue.contains(id)) {
			return Mono.error(new RuntimeException("Item with ID " + id + " is already queued"));
		}
		Sinks.emitResult er = sink.tryEmitNext(item);
		if (er.isSuccess()) {
			idsInQueue.add(id);
			return Mono.empty();
		}
		return Mono.error(new RuntimeException("Failed to emit item: " + er));
	}
	
	public Flux<T> poll() {
		return flux;
	}
	
	public Set<I> getIdsInQueue() {
		return Collections.unmodifiableSet(idsInQueue);
	}
	
	public void remove(I id) {
		idsInQueue.remove(id);
	}
	
}
