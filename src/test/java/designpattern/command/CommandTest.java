package designpattern.command;

public class CommandTest {
    public static void main(String[] args) {
        SimpleRemoteControl remoteControl = new SimpleRemoteControl();
        Light light = new Light();
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        remoteControl.setCommand(lightOnCommand);
        remoteControl.buttonWasPressed();
    }

}


interface MyCommand {
    void execute();
}

class LightOnCommand implements MyCommand {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}

class Light {
    public void on() {
        System.out.println("灯开了。。。。");
    }
}

class SimpleRemoteControl {
    MyCommand command;

    public void setCommand(MyCommand command) {
        this.command = command;
    }

    public void buttonWasPressed() {
        command.execute();
    }
}










