public class T1 implements  Runnable{
    Chat chat;
    String [] str={"Hi","How are you?", "I am also fine!"};

    public T1(Chat chat){
        this.chat=chat;
        new Thread(this,"Question Thread").start();
    }


    @Override
    public void run() {
        for(int i=0;i<str.length;i++){
            chat.question(str[i]);
        }
    }
}
