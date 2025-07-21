public class IntThread  extends Thread{



    private String message;

    public IntThread(String message) {
        super(message);
    }

    @Override
    public void run(){
        //System.out.println(message);
        for(int i=0;i<10;i++){
            System.out.println("Int Thread: "+ i +this.getName());

            try{
                Thread.sleep(200);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }



    }
}
