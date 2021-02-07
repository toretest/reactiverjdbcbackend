package reative;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Learing {

        final int max = 5;
        final int min = 1;
        Flux<Integer> evenNumbers = Flux
                .range(min, max)
                .filter(x -> x % 2 == 0); // i.e. 2, 4

        Flux<Integer> oddNumbers = Flux
                .range(min, max)
                .filter(x -> x % 2 > 0);  // ie. 1, 3, 5

        Flux<Integer> fluxOfIntegers = Flux.zip(
                evenNumbers,
                oddNumbers,
                (a, b) -> a + b);

    @Test
    public void givenFluxes_whenZipIsInvoked_thenZip() {
        Flux<Integer> fluxOfIntegers = Flux.zip(
                evenNumbers,
                oddNumbers,
                (a, b) -> a + b);

        StepVerifier.create(fluxOfIntegers)
                .expectNext(3) // 2 + 1
                .expectNext(7); // 4 + 3
                //.FaceTimeexpectComplete()

    }
}
