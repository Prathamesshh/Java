class complex
{
int real;
int img;
void input(int r,int i)
{
 real = r;
 img = i;
}
complex add(complex c2){
complex temp = new complex();
temp.real = real + c2.real;
temp.img = img + c2.img;
return(temp);
}
complex multi(complex c3){
complex temp2 = new complex();
temp2.real = (real * c3.real) - (img * c3.img);
temp2.img = (real*c3.img) + (img*c3.real);
return(temp2);
}
}
public class pract1{
public static void main(String[] args){
complex x1 = new complex();
complex x2 = new complex();
complex x3 = new complex();
complex x4 = new complex();
x1.input(4,8);
x2.input(12,8);
x3 = x1.add(x2);
x4 = x1.multi(x2);
System.out.println("Addition: "+x3.real + "+" + x3.img + "i");
System.out.println("Multiplication: "+x4.real + "+" + x4.img + "i");
}
}
    

