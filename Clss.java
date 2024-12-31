public class Clss {
    public static void main(String[] args) {

        Cookie cookieOne = new Cookie("Green");

        cookieOne.setColor("red");

        System.out.println(cookieOne.getColor());

    }
}

class Cookie {

    private String color;

    public Cookie(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }
}