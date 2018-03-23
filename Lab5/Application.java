public class Application {

    public static void main(String[] args) {

        if (args == null || args.length < 1 || args.length > 2)
            System.out.println("Error");
        else {
            Invoker invoker = new Invoker();
            Reciever reciever = new Reciever();
            if (args.length == 1) {
                if (args[0].equals("help")) {
                    invoker.setCommand(new Help(reciever));
                    return;
                }
                if (args[0].equals("exit")) {
                    invoker.setCommand(new Exit(reciever));
                    return;
                }
            } else if (args.length == 2) {
                if (args[0].equals("echo")) {
                    reciever = new Reciever(args[1]);
                    invoker.setCommand(new Echo(reciever));
                    return;
                }
                if (args[0].equals("date")) {
                    if (!args[1].equals("now"))
                        System.out.println("Error");
                    else {
                        invoker.setCommand(new Date(reciever));
                    }
                    return;
                }
            }
            System.out.println("Error");
        }
    }
}

//Command
interface Command {
    public void execute();
}

//Invoker
class Invoker {
    private Command command;
    public void setCommand(Command command){
        this.command = command;
        command.execute();
    }
}

//Receiver
class Reciever {
    String message;
    public Reciever (String messaage) {
        this.message = messaage;
    }
    public Reciever() {}
    public void help(){
        System.out.println("Help executed");
    }
    public void echo(){
        System.out.println(message);
    }
    public void date(){
        System.out.println(System.currentTimeMillis());
    }
    public void exit(){
        System.out.println("Goodbye!");
    }
}

//Concrete Command
class Help implements Command{
    Reciever reciever;
    public Help (Reciever reciever){
        this.reciever = reciever;
    }
    public void execute(){
        reciever.help();
    }
}

//Concrete Command
class Echo implements Command{

    Reciever reciever;
    public Echo (Reciever reciever){
        this.reciever = reciever;
    }

    public void execute(){
        reciever.echo();
    }
}

//Concrete Command
class Date implements Command{
    Reciever reciever;
    public Date (Reciever reciever){
        this.reciever = reciever;
    }
    public void execute(){
        reciever.date();
    }
}

//Concrete Command
class Exit implements Command{
    Reciever reciever;
    public Exit (Reciever reciever){
        this.reciever = reciever;
    }
    public void execute() {
        reciever.exit();
    }
}