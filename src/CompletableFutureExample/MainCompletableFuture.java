package CompletableFutureExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCompletableFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "you");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "are");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "beautiful");

        CompletableFuture<Void> combinedFutures = CompletableFuture.allOf(future1, future2, future3);
        try {
            combinedFutures.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println(future1.isDone());
        System.out.println(future2.isDone());
        System.out.println(future3.isDone());


        String combined=Stream.of(future1,future2,future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));

        System.out.println(combined);


        final String name=null;
        CompletableFuture<String> future=CompletableFuture.supplyAsync(()->{
            if(name==null){
                throw new RuntimeException("Exception occurs");
            }
            return "Hello " + name;
        }).handle((result,exception)->result!=null?result: "Hello" +"Stranger!");

        System.out.println(future.get());

        CompletableFuture<String> future10=new CompletableFuture<>();

        future10.completeExceptionally(new RuntimeException("Calculation failed!"));

        future10.get();

    }


}
