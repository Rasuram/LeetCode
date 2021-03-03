package allexamples;

import java.io.*;
/*
*
* Please write the control software to support the following requirements:
02

03
The cabinet will have 10 different locations with 3 different size bins to store medications.
04
"large" - 2 bins - stores "15 units"
05
"medium" - 5 bins - stores "10 units"
06
"small" - 3 bins" - stores "5 units"
07
The user will specify what is stored in each bin.   They will need to maintain the following attributes:
08
Medication ID (NDC)
09
Medication Name
10
Bins can be reset to support different medications based on customer needs.
11
A user will be able to add or remove medications from a bin
12
System must track what each specific users adds/removes from a cabinet (for compliance purposes)
13
System must be able to report out what medications need to be "reordered" based on low inventory (under 20% capacity) and recent medication usage.
14
Handle as many relevant edge cases as realistically possible.
15

16
Write a scneario test to validate the functionality.  Write unit tests where feasilbe.
17

18
C# or Javascript is prefered but use which language is best for you.

*
* */
class myCode
{

    int counter=0;

    Bin[] bins =  new Bin[5];
    class Bin{
        private String medicationName;
        private String medicationId;

        Bin(String medicationId, String medicationName){
            this.medicationName = medicationName;
            this.medicationId = medicationId;
        }
    }




    public void addBin(String medicationId, String medicationName){
        //bins = new Bin[counter];
        Bin bin = new Bin(medicationId,medicationName);
        bins[counter] = bin;
        counter++;
        Bin[] copyArray = new Bin[bins.length];
        // copy contents of intArray to copyArray
        System.arraycopy(bins, 0, copyArray, 0, bins.length);

       bins = copyArray;
    }


    public void removeBin(int removeBin){
        bins[removeBin] = null;
    }


    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(input);
        myCode myCode = new myCode();
        myCode.addBin("123","test");
        myCode.addBin("124","test1");
        myCode.addBin("125","test2");
        myCode.removeBin(2);
        System.out.println(myCode.bins);


    }
}
