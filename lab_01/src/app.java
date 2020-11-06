import java.util.ArrayList;
import java.util.Date;

public class app {
    public static Student[] Students = new Student[10];

    public static void main(String[] args) {

        Students[0] = new Student(0, "Аблаев", "Артур", "Зинурович", new Date(1998, 08 , 11), "Бахчисарай", "+79787278622", "Менеджемнт и экономика", 3, "I-2-18");
        Students[1] = new Student(0, "Одобаши", "Сали", "Асанович", new Date(1999, 07 , 10), "Судак", "+79116695947", "Менеджемнт и экономика", 3, "I-2-18");
        Students[2] = new Student(0, "Мартыненко", "Роман", "Сергеевич", new Date(1999, 08 , 25), "Джанкой", "+79180303030", "Менеджемнт и экономика3", 3, "I-2-18");
        Students[3] = new Student(0, "Дмитриева", "Владислава", "Олеговна", new Date(1999, 04 , 30), "Севастополь", "+79784268630", "Менеджемнт и экономика2", 3, "I-2-18");
        Students[4] = new Student(0, "Абибулаев", "Ленур", "Бахтиярович", new Date(1999, 02 , 25), "Керчь", "+79999999999", "Менеджемнт и экономика", 3, "I-2-18");
        Students[5] = new Student(0, "Кармацкий", "Евгений", "Валерьевич", new Date(2000, 10 , 25), "Симферополь", "+79782725535", "Менеджемнт и экономика", 3, "I-2-18");
        Students[6] = new Student(0, "Собко", "Сергей", "Сергеевич", new Date(2000, 08 , 20), "Бахчисарай", "+794258524689", "Менеджемнт и экономика", 3, "I-2-18");
        Students[7] = new Student(0, "Фисун", "Марк", "Данилович", new Date(2000, 06 , 5), "Евпатория", "+76562016520", "Менеджемнт и экономика", 3, "I-2-18");
        Students[8] = new Student(0, "Малыгин", "Дмитрий", "Владимирович", new Date(2000, 05 , 15), "Саки", "+16548769124", "Менеджемнт и экономика3", 3, "I-2-18");
        Students[9] = new Student(0, "Халилов", "Эдэм", "Русланович", new Date(2000, 02 , 13), "Ялта", "+79787287771", "Менеджемнт и экономика", 3, "I-2-18");


        //Search1();
        //Search2();
        //Search3();
        Search4();
    }

    public static void Search1()
    {
        for (int i=0; i<Students.length; i++)
        {
            if (Students[i].Facultet == "Менеджемнт и экономика")
            {
                System.out.println(Students[i].toString());
            }
        }
    }

    public static void Search2()
    {
        ArrayList<String> Facultets = new ArrayList<>();


        for (int i=0; i<Students.length; i++)
        {
            if (Facultets.size() == 0)
            {
                Facultets.add(Students[i].Facultet);
            }
            boolean flag = false;

            for (int i2=0; i2<Facultets.size(); i2++)
            {
                if (Facultets.get(i2).toString() == Students[i].Facultet.toString())
                {
                    flag = true;
                    //System.out.println(Students[i].toString());
                }
            }
            if (!flag)
            {
                Facultets.add(Students[i].Facultet);
            }
        }


        for (int i=0; i<Facultets.size(); i++)
        {
            System.out.println("Список №" + i);

            for (int i2=0; i2<Students.length; i2++)
            {
                if (Facultets.get(i) == Students[i2].Facultet)
                {
                    System.out.println(Students[i2].toString());
                }
            }
            System.out.println("");
        }
    }

    public static void Search3()
    {
        for (int i=0; i<Students.length; i++)
        {
            if (Students[i].data.getYear() >= 2000)
            {
                System.out.println(Students[i].toString());
            }
        }
    }

    public static void Search4()
    {
        for (int i=0; i<Students.length; i++)
        {
            System.out.println(Students[i].toString());
        }
    }
}
