import java.util.*;

public class Server {
    public String name;
    public String ipDirection;
    public String state; // on, off, restarting
    public double cpuUsage;
    public double memoryUsage;

    public Server(String name, String ipDirection) {
        this.name = name;
        this.ipDirection = ipDirection;
        this.state = "off";
        this.memoryUsage = 0.0;
        this.cpuUsage = 0.0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIpDirection() {
        return this.ipDirection;
    }

    public void setIpDirection(String newIp) {
        this.ipDirection = newIp;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public double getMemoryUsage() {
        return memoryUsage;
    }

    //methods change the state

    public void turnOn(){
        if (this.state.equals("on")){
            System.out.println("Server on... ");
        } else {
            this.state = "on";
            System.out.println(name + " server is on");
        }
    }

    public void turnOff(){
        if (this.state.equals("off")){
            System.out.println( this.name + " is off... ");
        } else {
            this.state = "off";
            System.out.println(this.name + " server off");
        }
    }

    public void restart(){
        if(!state.equals("on")){
            System.out.println("Server must be on to be restarted ");
        } else {
            System.out.println("RESTARTING... ");
            this.state = "restarting";
            try{
                Thread.sleep(3000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            this.state = "on";
            System.out.println(this.name + "'s been restarted");
        }
    }

    public void simulation(){
        Random random = new Random();
        this.cpuUsage = 10 + random.nextDouble() * 70;
        this.memoryUsage = 10 + random.nextDouble() * 60;
        System.out.println("server: " + this.name + " is working, CPU: " +
                            String.format("%.2f", cpuUsage) + "%, memory: " +
                            String.format("%.2f", memoryUsage) + "%");
    }

}
