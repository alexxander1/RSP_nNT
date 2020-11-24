import java.io.*;
import java.net.Socket;

//Поток ServerSomthing
class ServerSomthing extends Thread {

    private Socket socket; // сокет сервера
    private BufferedReader in;  // буфер чтения из сокета
    public BufferedWriter out; // буфер завписи в сокет


    public ServerSomthing(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        start(); //старт связи в бесконечном цикле
    }

    @Override
    public void run() {
        String word;
        try {
            try {
                while (true) {
                    word = in.readLine();
                    if(word.equals("stop server")) {
                        this.stopService(); // стоп сервиса
                    }
                    System.out.println("Принятое сообщение: " + word);

                    Server.bufer.addBufer(word);  //Добовляем сообщение в буфер
                }
            } catch (NullPointerException ignored) {}


        } catch (IOException e) {
            this.stopService();
        }
    }

    private void stopService() {
        try {
            if(!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                for (ServerSomthing vr : Server.serverList) {
                    if(vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {}
    }
}
