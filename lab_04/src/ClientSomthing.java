import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

class ClientSomthing {

    private Socket socket;
    private BufferedReader in;          // поток чтения из сокета
    private BufferedWriter out;         // поток записи в сокет
    private BufferedReader inputUser;   // поток чтения с консоли
    private String addr;                // ip адрес клиента
    private int port;                   // порт соединения

    private Date time;
    private String dtime;
    private SimpleDateFormat dt1;


    // нить/связь клиента с сервером
    public ClientSomthing(String addr, int port) {
        this.addr = addr;   //ip
        this.port = port;   //port
        try {
            this.socket = new Socket(addr, port);   //запуск сокета
        } catch (IOException e) {
            System.err.println("Ошибка запуска сокета");    //Ошибка запуска или коннекта к серверу
        }
        try {
            inputUser = new BufferedReader(new InputStreamReader(System.in));
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));        //Буфер чтения
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));     //Буфер записи

            new ReadMsg().start(); // запуск потока чтения сообщений с сервера
            new WriteMsg().start(); // нить пишущая сообщения в сокет приходящие с консоли в бесконечном цикле
        } catch (IOException e) {
            // Сокет должен быть закрыт при любой ошибке
            ClientSomthing.this.stopService();
        }

        // В противном случае сокет будет закрыт
        // в методе run() нити.
    }

    //закрытие сокета
    private void stopService() {
        try {
            if (!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
            }
        } catch (IOException ignored) {}
    }

    // нить чтения сообщений с сервера
    private class ReadMsg extends Thread {
        @Override
        public void run() {

            String str;
            try {
                while (true) {
                    str = in.readLine();    // ждем сообщения с сервера
                    if (str.equals("stop")) {
                        ClientSomthing.this.stopService(); // останавливаем сокет
                        break; // выходим из цикла если пришло "stop"
                    }
                    System.out.println(str); // пишем сообщение с сервера на консоль
                }
            } catch (IOException e) {
                ClientSomthing.this.stopService();  //останавливаем сли ошибка
            }
        }
    }

    // нить отправляющая сообщения
    public class WriteMsg extends Thread {

        @Override
        public void run() {
            while (true) {
                String userWord;
                try {
                    time = new Date();          // текущая дата
                    dt1 = new SimpleDateFormat("HH:mm:ss");     // берем только время до секунд
                    dtime = dt1.format(time);   // время
                    userWord = inputUser.readLine(); // ввод с консоли
                    if (userWord.equals("stop")) {
                        out.write("stop" + "\n");
                        ClientSomthing.this.stopService(); // харакири
                        break; // выходим из цикла если пришло "stop"
                    } else {
                        out.write("(" + dtime + ") " + ": " + userWord + "\n"); // отправляем на сервер
                    }
                    out.flush(); // чистим
                } catch (IOException e) {
                    ClientSomthing.this.stopService(); // в случае исключения тоже харакири

                }

            }
        }
    }
}
