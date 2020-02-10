package CSE;

public class Thirdsem
{
    public Thirdsem()
    {
        Welcomemsg();
        printinfo();
        myparent();
        mychildren();
    }
    public void Welcomemsg()//public method
    {
        System.out.println("Welcome to CSE dept - 3rd sem young budding Engineers");
    }
    private void printinfo()//private method
    {
        System.out.println("This is class Thirdsem");
    }
    protected void myparent()//protected method
    {
        System.out.println ("I have no parent");
    }
    void mychildren ()
    {
        System.out.println("Cse_dept is my child");
    }
}
