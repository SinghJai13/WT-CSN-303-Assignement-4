class Solution2
{
    public static void main(String[] args)
    {
        int value=-1;
        byte b=(byte)value;

        char ch=(char)b;

        int final_val=ch;
        System.out.println("Intial Value : "+value);
        System.out.println("After Conversion to Byte : "+ b);
        System.out.println("Conversion to Charcter : "+ ch);
        System.out.println("Final Value : "+final_val);



        //-1 is an integer
        
        //int falls within range of byte(which is signed) hence the value remains same in byte
        // converting byte to char, now char is unsigned. So it gets converted to 2^16 - 1
        //int is a larger data type hence value of char remains same

    }
}
