public class CheckMark {

    public static void main(String[] args) {

        String checkMark = new String("\u001B[32m" + "✔" + "\u001B[0m");

        System.out.println("Constructor test " + checkMark);
        System.out.println("ToString test " + checkMark);
        System.out.println("A on coding test " + checkMark);
        System.out.println("Life better now because of " + checkMark);


    }
}
