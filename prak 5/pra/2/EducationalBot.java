public class EducationalBot extends Chatbot{
    public EducationalBot(String name){
        super(name);
    }

    public void respond(){
        System.out.println("Educational bot "+ getName() + " siap membantu belajar Anda");
    }

    public void displayInfo(){
        System.out.println("Educational Bot "+ getName() + " telah melayani " + getSessionCount() + " sesi");
    }

    public void teachTopic(String topic){
        System.out.println("Mengajarkan topik: " + topic);
    }

    public String getBotType(){
        return "Educational Bot";
    }
}