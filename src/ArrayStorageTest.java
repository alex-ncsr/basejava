import java.util.Arrays;

public class ArrayStorageTest {

    static ArrayStorage arrayStorage = new ArrayStorage();

    public static void main(String[] args) {


        Resume r1 = new Resume();
        r1.uuid = "uuid1";
        Resume r2 = new Resume();
        r2.uuid = "uuid2";
        Resume r3 = new Resume();
        r3.uuid = "uuid3";
        Resume r4 = new Resume();
        r4.uuid = "uuid4";

        arrayStorage.save(r1);
        arrayStorage.save(r2);
        arrayStorage.save(r3);
        arrayStorage.save(r4);

        System.out.println(Arrays.toString(arrayStorage.storage));

        System.out.println(arrayStorage.get("uuid1"));
        System.out.println(arrayStorage.get("uuid2"));
        System.out.println(arrayStorage.get("uuid3"));
        System.out.println(Arrays.toString(arrayStorage.getAll()));


        System.out.println(arrayStorage.size());

        arrayStorage.delete("uuid2");
        System.out.println(Arrays.toString(arrayStorage.getAll()));

        System.out.println(Arrays.toString(arrayStorage.storage));
        System.out.println(arrayStorage.size());

        arrayStorage.clear();

        System.out.println(Arrays.toString(arrayStorage.storage));
        System.out.println(arrayStorage.size());




    }
}
