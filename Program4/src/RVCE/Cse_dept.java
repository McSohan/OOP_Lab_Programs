package RVCE;
import CSE.*;

final public class Cse_dept extends Thirdsem
{
    public Cse_dept()
    {
        super.Welcomemsg();
        Welcomemsg();
        printinfo();
        myparent();
        mychildren();
    }
    public void Welcomemsg()
    {
        System.out.println("Welcome to RVCE - overriding the other method");
    }
    private void printinfo()
    {
        System.out.println("This is class Cse_dept");
    }
    protected void myparent()
    {
        System.out.println ("My parent is Thirdsem");
    }
    void mychildren ()
    {
        System.out.println("I have no children");
    }
}
