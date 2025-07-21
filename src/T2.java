public class T2  implements   Runnable{
    Chat chat;
    String [] str={"Hello","I am good What about you", "thats very good"};

    public T2(Chat chat){
        this.chat=chat;
        new Thread(this,"Answer Thread").start();
    }


    @Override
    public void run() {
        for(int i=0;i<str.length;i++){
            chat.answer(str[i]);
        }
    }
}
