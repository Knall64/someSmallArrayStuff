
/*
 * Herzliches Willkommen im Array-Toolkit, Copyright David :D
 * Diese Klasse ist darauf ausgelegt möglichst schnell und einfach mit Arrays jonglieren zu können,
 * insbesondere wurde ein kleiner Fokus drauf ausgelegt Arrays wie dynamische Listen behandeln zu
 * können. 
 * 
 * Ich gebe selbstverständlich keine Garantie dass all dieser Code fehlerfrei funktioniert und/oder
 * dass die Nutzung dieses Codes in der Prüfung nicht zu einem Plagiat führt (dies sollte jedoch
 * abgeklärt sein).
 * 
 * Code von: https://github.com/Knall64/someSmallArrayStuff/blob/main/Arrayz.java (Stand: 14.11.23, 14:27)
 */
//TESTARRAYS
//[]
//[0]
//[0,-2,9737]
//[Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE]
//[Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE]
//[0,0,0,0,0]
//TESTARRAYS

class Arrayz{
    /*
     * Die Klasse unterstützt ausschließlich statische Methoden.
     */
    public Arrayz(){
        throw new UnsupportedOperationException();
    }

    public static void Tmain(String[] args){
	    throw new UnsupportedOperationException();
    }

    /*
     * ###GRUNDLEGENDE MANIPULATION###
     * 
     * Diese Methoden sind grundlegende Manipulationsmethoden für Arrays.
     */
    public static void print(int[] a){
        System.out.print("[");
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]);
            if(!(i+1>=a.length)){
               System.out.print(", "); 
            }
        }
        System.out.print("]");
        System.out.print("\n");
    }

    public static void print(int[][] a){
        for(int i=0;i<a.length;i++){
            print(a[i]);
        }
    }


    /**
     * Konvertiert einen reinen Int wert in ein Array mit der Länge 1, generell zum weiterarbeiten
     * mit z.B. Merge gedacht
     * @param a Int Wert
     * @return Int Array
     */
    public static int[] toArray(int a){
        return new int[]{a};
    }


    /**
     * Returnt ein Subarray von Index from zu Index to.
     * @param a Array
     * @param from (inklusiv)
     * @param to (exklusiv)
     * @return Subarray
     */
    public static int[] subarray(int[] a, int from, int to){
        if(from>=to || !indexInBounds(a, from) || !indexInBounds(a, to-1)){
            return new int[]{};
        }
        
        int len = 0;
        for (int i=from;i<=to;i++){
            len++;
        }

        int[] sub = new int[len-1];
        int cc = 0;
        for (int j=from;j<to;j++){
            sub[cc] = a[j];
            cc++;
        }

        return sub;
    }

    /**
     * Schaut ob ein Index in bounds zu einem Array ist. Nützlich in ifs
     * @param a Array
     * @param b Index
     * @return True = In bounds, False = out of bounds
     */
    public static boolean indexInBounds(int[] a, int b){
        if (b<0 || b>=a.length){
            return false;
        }
        return true;
    }
    public static boolean indexInBounds(int[][] a, int b){
        if (b<0 || b>=a.length){
            return false;
        }
        return true;
    }


    /**
     * Schaut ob ein Wert in einem Array ist
     * Anderer Methodenname: contains
     * @param a Array
     * @param n Wert
     * @return True = Ist im Array, False = Ist nicht
     */
	public static boolean in(int[] a, int n){
		for (int i = 0; i<a.length;i++){
			if (n == a[i]){
				return true;
			}
		}
		return false;
	}

    public static boolean contains(int[] arr1, int a){
        return in(arr1, a);
    }

    /**
     * Ändert die Länge eines Arrays, bei kürzer werden Werte abgeschnitten, bei Länger standardmäßig mit 0 aufgefüllt.
     * @param a Array
     * @param length Länge
     */
    public static int[] resize(int[] a, int length){
        
        return resize(a,length,0);
    }

    /**
     * Ändert die Länge eines Arrays, bei kürzer werden Werte abgeschnitten, bei Länger mit fill aufgefüllt.
     * @param a Array
     * @param length Länge
     * @param fill Fülle
     */
    public static int[] resize(int[] a, int length, int fill) {
		if (length <= 0){
			return new int[]{};
		}
		int[] b = new int[length];

		for (int i=0; i<b.length;i++){
			if (i==a.length){
				for (int x=a.length;x<b.length;x++){
					b[x] = fill;
				}
                return b;
			}
			b[i] = a[i];
		}

        return b;
    }

    /**
     * Schaut ob ein Array gleich einem anderen ist (NIE MIT == MACHEN)
     * @param arr1 
     * @param arr2
     * @return True = Gleich, False = Ungleich
     */
    public static boolean equals(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length){
            return false;
        }

        for(int i=0;i<arr1.length;i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }

    /**
     * Schaut ob ein Array ein anderes beinhaltet, es wird beachtet wie die Zahlen angeordnet sind
     * [1,2,3] und [1,2] = true
     * [1,2,3] und [2,1] = false (siehe ContainsAll)
     * @param arr1
     * @param sub
     * @return True=Enthalten, False=Nicht
     */
    public static boolean subarray(int[] arr1, int[] sub){
        //antike dunkelrituale
        String top = "";
        for(int i=0;i<arr1.length;i++){
            top = top + arr1[i] + ",";
        }
        String bottom = "";
        for(int i=0;i<sub.length;i++){
            bottom = bottom + sub[i] + ",";
        }

        return top.contains(bottom);
    }


    /**
     * Schaut ob arr1 alle elemente aus a containt
     * @param arr1 Hauptarray
     * @param a
     * @return True = ja, False = nein
     */
    public static boolean containsAll(int[] arr1, int[] a){

        for (int i=0;i<a.length;i++){
            if (contains(arr1,a[i]) != true){
                return false;
            }
        }
        return true;
    }


    /**
     * Erstellt ein Array gefüllt mit filled, soll etwss zeilen sparen :)
     * @param length
     * @param filled
     * @return
     */
    public static int[] array(int length, int filled) {
        int[] o = new int[length];

        for (int i=0;i<length;i++){
            o[i] = filled;
        }

        return o;
    }
    
    /**
     * Erstellt ein array gefüllt mit 0.
     * @param length
     * @return
     */
    public static int[] array(int length) {
        return array(length, 0);
    }

    /**
     * Nimmt die gemeinsamen Elemente aus beiden Arrays.
     * @param a
     * @param b
     * @return
     */
    public static int[] commons(int[] a, int[] b){
        int[] da = distinctArray(a);
        //int[] db = distinctArray(b);
        int[] dynamic = new int[]{};
        for (int i=0;i<da.length;i++){
            if (in(b,da[i]) == true){
                dynamic = append(dynamic,da[i]);
            }
        }
        return dynamic;
    }

    /**
     * Gibt den ersten Index einer Nummer b aus.
     * @param a
     * @param b
     * @return Index, -1 wenn keiner
     */
    public static int indexOf(int[] a, int b){
        for (int i=0;i<a.length;i++){
            if (a[i] == b){
                return i;
            }   
        }
        return -1;
    }

    /**
     * Gibt alle Indexe einer Nummer b aus.
     * @param a
     * @param b
     * @return
     */
    public static int[] indexesOf(int[] a, int b){
        int[] list = new int[]{};
        for (int i=0;i<a.length;i++){
            if (a[i] == b){
                list = append(list,i);
            }   
        }
        return list;
    }

    /**
     * Gibt die Anzahl einer Nummer aus.
     * @param a
     * @param b
     * @return
     */
    public static int amountOf(int[] a, int b){
        int cc = 0;

        for(int i=0;i<a.length;i++){
            if (a[i] == b){
                cc++;
            }
        }

        return cc;
    }


    /**
     * Gibt die Summe aller Längen aus. (siehe minLength, maxLength)
     */
    public static int sumLen(int[][] m){
        int len = 0;
        for (int i=0;i<m.length;i++){
            len += m[i].length;
        }
        return len;
    }


    /**
     * Kopiert ein Array.
     * @param a
     * @return
     */
    public static int[] copyOf(int[] a){
        int[] newi = new int[a.length];
        for(int i=0;i<a.length;i++){
            newi[i] = a[i];
        }
        return newi;

    }

    /**
     * Erstellt ein Array von range from bis to
     * @param from (inklusive)
     * @param to (exklusive)
     * @return
     */
    public static int[] range(int from, int to){
        int[] rang = new int[]{};
        for(int i=from;i<to;i++){
            rang = append(rang, i);
        }
        return rang;
    }

    /**
     * Erstellt ein Array  bis to
     * @param to (exklusive)
     * @return
     */
    public static int[] range(int to){
        return range(0,to);
    }


    /**
     * Tauscht zwei Indexe aus
     * @param a
     * @param i1
     * @param i2
     */
    public static void swap(int[] a, int i1, int i2){
        if(indexInBounds(a, i2) && indexInBounds(a, i1)){
        int temp = a[i1];
        a[i1] = a[i2];
        a[i2] = temp;
        }
    }

     public static void rotate(int[] array, int amount) {
        if (amount == 0 || array.length < 2){
            return;
        }
        else if (amount > 0){
            for (int i=0;i<amount;i++){
                rotateRight(array);
            }
        }
        else if (amount < 0){
            for (int i=0;i<abs(amount);i++){
                rotateLeft(array);
            }
        }
    }

    public static void rotateRight(int[] a){
        int[] temp = new int[a.length];
        for (int i=0;i<a.length;i++){
            temp[i] = a[i];
        }

        //a[0] = temp[temp.length-1];
        for (int j=0;j<a.length-1;j++){
            a[j+1] = temp[j];
        }

        a[0] = temp[temp.length-1];

    }

    public static void rotateLeft(int[] a){
        for (int z=0;z<a.length-1;z++){
            rotateRight(a);
        }
    }





    public static int abs(int a){
        if (a<0){
            return a*-1;
        }
        else{
            return a;
        }
    }
	
    /** Zählt die Anzahl an Vorkommen jeder Zahl im übergebenen Array, die in diesem mindestens einmal vorkommt.
     *  Die Rückgabe erfolgt über ein 2D-Array, bei dem jedes innere Array aus zwei Einträgen besteht: Einer Zahl,
     *  die im übergebenen Array vorkommt sowie der Anzahl an Vorkommen dieser.
     *  Für jede im übergebenen Array vorkommenden Zahl gibt es ein solches inneres Array.
     *  Diese tauchen im Rückgabewert in der gleichen Reihenfolge auf, in der die jeweils ersten Vorkommen der Zahlen
     *  im übergebenen Array auftauchen.
     *
     * @param array Ein beliebiges Integer-Array
     * @return Das Array mit den Vielfachheiten der einzelnen Zahlen, wiederum als Integer-Arrays mit zwei Einträgen dargestellt.
     */
    public static int[][] quantities(int[] array) {
        int[] track = distinctArray(array);

        int[][] quant = new int[track.length][2];

        for (int z=0;z<track.length;z++){
            quant[z][0] = track[z];
        }

        for (int i=0;i<track.length;i++){
            int current = track[i];

            for (int j=0; j<array.length;j++){
                if (current == array[j]){
                    quant[i][1] += 1;
                }
            }

        }


        return quant;
    }


    /*
     * ###MATHEMATIK###
     * HANZ GET ZE FLAMMENWERFER
     * JAWOLL
     */
    public static int min(int[] a){
        if (a.length == 0){
			return 0;
		}

		int min = a[0];

		for (int i : a){
			if (i<min){
				min = i;
			}
		}
		return min;
    }

    public static int max(int[] a){
        if (a.length == 0){
            return 0;
		}

		int max = a[0];
		for (int i : a){
			if (i>max){
				max = i;
			}
		}
        return max;
    }

    public static int maxLen(int[][] a){
        if (a.length == 0){
            return 0;
		}

		int max = a[0].length;

		for (int[] i : a){
			if (i.length>max){
				max = i.length;
			}
		}
        return max;
    }

    public static int minLen(int[][] a){
         if (a.length == 0){
            return -1;
		}

		int min = a[0].length;

		for (int[] i : a){
			if (i.length<min){
				min = i.length;
			}
		}
        return min;
    }
    

    public static int min(int[] a, int from, int to){
        int[] b = subarray(a, from, to);
        return min(b);
    }

    public static int max(int[] a, int from, int to){
        int[] b = subarray(a, from, to);
        return max(b);
    }

    public static int sum(int[] a){
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        return sum;
    }
    /*
     * Testet nicht auf overflows!
     */
    public static int power(int[] a){
        int sum = 0;
        for(int i=0;i<a.length;i++){
            sum+=a[i]*a[i];
        }
        return sum;
    }

    public static long sumOfSquares(int[] array) {
        long dong = 0L;
        for (int i=0;i<array.length;i++){
            long x = array[i];
            long y = x * x;
            if (y<0){
                System.out.println("Overflow!");
            return -1;
            }
            dong += y;
            if (dong<0){
            System.out.println("Overflow!");
            return -1;
        }
        }

        if (dong<0){
            System.out.println("Overflow!");
            return -1;
        }
        return dong;
    }

    public static int average(int[] a){
        if (a.length == 0){return 0;}
        return sum(a)/a.length;
    }

    public static int median(int[] a){
        //0 1 2 3 4 5 6 7 8 9 10
        //0 1 2 3 4 
        if(a.length==0){return 0;}
        if (a.length%2!=0){
            return a[(a.length-1)/2];
        }
        else{
        //0 1 2 3 _4 5_ 6 7 8 9 l10
        //0 _1 2_ 3 l4
            return (a[a.length/2]+a[(a.length/2)-1])/2;

        }
    }
    public static int sortedMedian(int[] a){
        //0 1 2 3 4 5 6 7 8 9 10 l11
        //0 1 2 3 4 l5
        int[] copy = copyOf(a);
        sortAsc(copy);
        return median(copy);
    } 


    /*
     * ###KONVERTIERUNG### 
     * 
     * Hier sind alle Klassen die ein Array zu einem anderen Typ konvertieren.
     */

    /**
     * Konvertiert ein int-Array zu einem char-Array.
     * @param a Int-Array
     * @return Char-Array
     */
    public static char[] toChar(int[] a)
    {
        char[] x = new char[a.length];
        for (int i=0;i<a.length;i++){
            x[i] = (char) a[i];
        }
        return x;
    }

    /**
     * Konvertiert ein Array zu einem int-Array.
     * @param a Array
     * @return Int-Array
     */
    public static int[] toInt(char[] a)
    {
        int[] x = new int[a.length];
        for (int i=0;i<a.length;i++){
            x[i] = (int) a[i];
        }
        return x;
    }
    public static int[] toInt(long[] a)
    {
        int[] x = new int[a.length];
        for (int i=0;i<a.length;i++){
            x[i] = (int) a[i];
        }
        return x;
    }
    public static int[] toInt(float[] a)
    {
        int[] x = new int[a.length];
        for (int i=0;i<a.length;i++){
            x[i] = (int) a[i];
        }
        return x;
    }
    public static int[] toInt(double[] a)
    {
        int[] x = new int[a.length];
        for (int i=0;i<a.length;i++){
            x[i] = (int) a[i];
        }
        return x;
    }

    public static long[] toLong(int[] a)
    {
        long[] x = new long[a.length];
        for (int i=0;i<a.length;i++){
            x[i] = (long) a[i];
        }
        return x;
    }

    public static float[] toFloat(int[] a)
    {
        float[] x = new float[a.length];
        for (int i=0;i<a.length;i++){
            x[i] = (float) a[i];
        }
        return x;
    }

    public double[] toDouble(int[] a)
    {
        double[] x = new double[a.length];
        for (int i=0;i<a.length;i++){
            x[i] = (double) a[i];
        }
        return x;
    }




    /*
     * ###SORTIERUNG### 
     * 
     * Hier sind alle Methoden die Arrays sortieren.
     * Der verwendete Sort ist ein unoptimisierter InsertionSort. (der einzige den ich aus dem FF kann lol) 
     */

     /**
      * Sortiert ein Array aufsteigend.
      * @param array Sortierendes Array, wird im gleichen Array ausgegeben
      */
    public static void sortAsc(int[] array){
        for (int i=1; i<array.length; i++){  
            int curr = array[i];  
            int j = i-1;  
            while (j > -1 && array[j] > curr) {  
                array[j+1] = array[j];  
                j--;  
            }  
            array[j+1] = curr;  
        }
    }  
    /**
      * Sortiert ein Array absteigend mit sortAsc und invert.
      * @param array Sortierendes Array, wird im gleichen Array ausgegeben
      */
    public static void sortDesc(int[] array){
            sortAsc(array);
            invert(array);
    }

    /**
     * Sortiert ein Array aufsteigend von 2 Indexes
     * @param array Sortierendes Array
     * @param from Index von dem es sortiert werden sollte. (Inklusive!)
     * @param to Index bis zu dem es sortiert werden sollte. (Exklusive!)
     * d.h. 0, array.length für alles
     */
    public static void sortAsc(int[] array, int from, int to){
        if(from>to || !indexInBounds(array, from) || !indexInBounds(array, to)){
           System.out.println("Wrong Index Formats!");
        }
        int[] sub1 = subarray(array,0, from);
        int[] main = subarray(array, from, to);
        int[] sub2 = subarray(main, to, array.length);

        sortAsc(array);

        array = merge(sub1, main, sub2);
    }

    /**
     * Sortiert ein Array absteigend von 2 Indexes
     * @param array Sortierendes Array
     * @param from Index von dem es sortiert werden sollte. (Inklusive!)
     * @param to Index bis zu dem es sortiert werden sollte. (Exklusive!)
     * d.h. 0, array.length für alles
     */
    public static void sortDesc(int[] array, int from, int to){
        if(from>to || !indexInBounds(array, from) || !indexInBounds(array, to)){
           System.out.println("Wrong Index Formats!");
        }
        int[] sub1 = subarray(array,0, from);
        int[] main = subarray(array, from, to);
        int[] sub2 = subarray(main, to, array.length);


        sortDesc(array);

        array = merge(sub1, main, sub2);
    }

    /**
     * Invertiert ein Array, daher [1,2,3] -> [3,2,1]
     * @param a Array
     */
    public static void invert(int[] a) {
		int[] temporary = new int[a.length];
		for (int o = 0; o<a.length;o++){
			temporary[o] = a[o];
		}
		int len = a.length-1;

		for (int i=0;i<a.length;i++){
			a[len-i] = temporary[i];
		}

	}

    /*
     * Manipulation
     * Methoden die ein Array manipulieren.
     */

    /**
     * Returnt ein Array ohne Wiederholungen.
     * @param a Array
     * @return Distinktes Array
     */
    public static int[] distinctArray(int[] a) {
		int[] n = new int[a.length];
		int c = 0;
		boolean zf = false;
		for (int i = 0;i<a.length;i++){
			if ((in(n, a[i]) == false && a[i] != 0) || (zf==false && a[i]==0)){
				n[c] = a[i];
				c++;

				if (a[i]==0){
					zf = true;
				}
			}
		}	
		int[] m = new int[c];
		for (int j = 0; j<m.length;j++){
			m[j] = n[j];
		}

		return m;
	}

    /*
     * ###MERGEN###
     * Zum zusammenfügen von Arrays
     */

    /**
     * Zippt zwei Arrays
     * @param a
     * @param b
     * @return
     */
    public static int[] zip(int[] a, int[] b) {
        int len = a.length + b.length;
        int[] zip = new int[len];

        int k = 0;
        for (int i=0;i<zip.length;i++){
            if (i<a.length){
                zip[k] = a[i];
                k++;
            }
            if (i<b.length){
                zip[k] = b[i];
                k++;
            }
            }
            return zip;
        }

    /**
     * Zippt mehrere Arrays (als matrix) in ein Array
     * @param arrays
     * @return
     */
    public static int[] zipMany(int[][] arrays) {
            int len = 0;
            for (int i=0;i<arrays.length;i++){
                len += arrays[i].length;
            }
    
            int[] zip = new int[len];
            int i = 0;
            int maxLength = 0;
            for (int[] row : arrays) {
                if (row.length > maxLength){
                    maxLength = row.length;
                }
            }
        
            for (int col = 0; col < maxLength; col++) {
                for (int row = 0; row < arrays.length; row++) {
                    if (col < arrays[row].length) {
                        zip[i] = arrays[row][col];
                        i++;
    
                    }
                }
            }
            return zip;
        }
    
    /**
     * Mergt zwei arrays linear
     * @param a
     * @param b
     * @return
     */
    public static int[] merge(int[] a, int[] b){
        for (int i=0;i<b.length;i++){
            a = append(a,b[i]);
        }
        return a;
    }

    /**
     * Tut eine Nummer am Ende eines Arrays
     * @param a
     * @param b
     */
    public static int[] append(int[] a, int b){
        int[] arr = new int[a.length+1];
        for(int i=0; i<a.length; i++){
            arr[i] = a[i];
        }
        arr[arr.length-1] = b;
        return arr;
    }
    
    /**
     * Fügt drei arrays zusammen
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static int[] merge(int[] a, int[] b, int[] c){
        int[] d = merge(a,b);
        return merge(d,c);
    }

    /**
     * Zip, aber Array2 wird langsamer rezipt. zipSpeed = 2 heißt es wird nur jedes zweites mal gezippt.
     * @param array1
     * @param array2
     * @param zipSpeed
     * @return
     */
    public static int[] unregZip(int[] a, int[] b, int zipSpeed){
        int len = a.length + b.length;
        int[] zip = new int[len];
        if(zipSpeed<=0){
            zipSpeed=1;
        }
        int zipzop = zipSpeed;
        int k = 0;
        int cc=0;
        for (int i=0;i<zip.length;i++){
            if (i<a.length){
                zip[k] = a[i];
                k++;
            }

            if(zipzop == 1){
            if (i<b.length || cc<b.length){
                zip[k] = b[cc];
                cc++;
                k++;
                zipzop = zipSpeed;
            }
            }else{
                zipzop--;
            }
        }
        return zip;
    }


    /**
     * Entzippt ein array. 
     * @param zipped
     * @return
     */
    public static int[][] unZip(int[] zipped){
        int[][] unz = new int[][]{{},{}};
        for (int i=0;i<zipped.length;i++){
            if(i%2==0){
                unz[0] = append(unz[0],zipped[i]);
            }else{
                unz[1] = append(unz[1],zipped[i]);
            }
        }

        return unz;
    }


    public static int[] append(int[] a, int num, int index){
        if (index == a.length){
            return append(a, num);
        }

        if(indexInBounds(a, index)){
        int[] s1 = subarray(a, 0, index);
        s1 = append(s1, num);
        int[] s2 = subarray(a, index, a.length);
        return merge(s1, s2);
        }
        else{
            return append(resize(a, index), num, index);
        }
    }

    /*
     * ###LÖSCHEN###
     * Löscht dinge.
     */

     /**
      * Löscht nen index. Wird gleich eliminiert.
      * @param a
      * @param index
      */
     public static int[] deleteIndex(int[] a, int index){
        if(indexInBounds(a, index)){
        int[] b = new int[a.length-1];
        int cc = 0;
        for (int i=0;i<a.length;i++){
            if (i != index){
                b[cc] = a[i];
                cc++;
            }
        }
        return b;
        }
        return a;

    }

    /**
     * Löscht nen index aus ner Matrix.
     * @param a
     * @param index
     */
    public static int[][] deleteIndex(int[][] a, int index){
        if(indexInBounds(a, index)){
        int[][] b = new int[a.length-1][];
        int cc = 0;
        for (int i=0;i<a.length;i++){
            if (i != index){
                b[cc] = a[i];
                cc++;
            }
        }
        return b;
        }
        return a;
    }

    public static int[] deleteIndexRange(int[] a, int[] index){
        index = distinctArray(index);

        if (index.length >= a.length){
            return new int[]{};
        }

        int[] b = new int[a.length-index.length];
        int cc = 0;
        for (int i=0;i<a.length;i++){
            if (!(in(index,i))){
                b[cc] = a[i];
                cc++;
            }
        }
        return b;
    }

    public static int[] deleteValue(int[] a, int value){
        int[] list = indexesOf(a, value);
        return deleteIndexRange(a, list);
    }

    /**
     * Löscht ne index range
     * @param a
     * @param from inklusiv
     * @param to exklusiv
     * 0,a.length würde alles löschen.
     */
    public static int[] deleteIndexRange(int[] a, int from, int to){
        int[] uno = subarray(a,0, from);
        int[] dos = subarray(a, to, a.length);
        return merge(uno,dos);
    }

    /**
     * Löscht eine Range aus values
     * @param a
     * @param from (inklusive)
     * @param to (exklusive)
     */
    public static int[] deleteValueRange(int[] a, int from, int to){
        int[] range = range(from, to);
        return deleteValueRange(a, range);
    }

    /**
     * Löscht eine Liste aus values
     * @param a
     * @param from
     */
    public static int[] deleteValueRange(int[] a, int[] from){
        int[] b = copyOf(a);
        for(int i=0;i<from.length;i++){
            b = deleteValue(b, from[i]);
        }
        return b;
    }

    /**
     * Tut ein Value in ein anderes abändern
     * @param a
     * @param replace
     * @param with
     */
    public static void replaceCertainValues(int[] a, int replace, int with){
        for (int i=0;i<a.length;i++){
            if (a[i] == replace){
                a[i] = with;
            }
        }
    }

    /**
     * Tut eine Liste von Werten in einen anderen änder, jeder Wert von replace wird mit with replacet.
     * @param a
     * @param replace
     * @param with
     */
    public static void replaceCertainValues(int[] a, int replace[], int with){
        for (int i=0;i<replace.length;i++){
            for(int r=0;r<a.length;r++){
                if(a[r] == replace[i]){
                    a[r] = with;
                }
            }

        }
    }

    /**
     * Tut eine Liste von Werten in andere ändern, hier wird per index gegangen. replace[i] wird mit with[i] replaced.
     * @param a
     * @param replace
     * @param with
     */
    public static void replaceCertainValues(int[] a, int replace[], int with[]){
        if (replace.length != with.length){
            return;
        }
        for (int i=0;i<replace.length;i++){
            replaceCertainValues(a,replace[i],with[i]);
        }
    }

    /*
     * ###Matrix-Manipulation###
     * Methoden die mit 2D-Arrays arbeiten.
     */

     
    /**
     * Konvertiert ein Array zur Matrix mit abhängigkeit 2 Parameter.
     * @param arr Array
     * @param width Weite der Matrix, hiermit ist das erste Feld gemeint matrix.length
     * @param height Weite der Matrix, hiermit ist das zweite Feld gemeint matrix[i].length
     * @return Matrix
     * Achtung! Schauen ob die Werte gleich der Länge des Array sind wird nicht geschaut! 
     */
    public static int[][] arrayToMatrix(int[] arr, int width, int height){
		int[][] matrix = new int[width][height];
		int k = 0;
		for (int h=0; h<height;h++){
			for (int w=0;w<width;w++){
				matrix[w][h] = arr[k];
				k++;
			}

		}

		return matrix;
	}

    /**
     * Erhält die Horizontale Reihe einer Matrix. Die Vertikale ist mit (matrix[n]) leicht einholbar.
     * @param m Matrix
     * @param row Reihe
     * @return Matrix-Reihe
     * Bei einer Matrix mit ungleichmäßigen Längen werden out-of-bounds-Zeilen einfach übersprungen.
     */
    public static int[] getHorizontal(int[][] m, int row){
        int[] x = new int[]{};
        for(int i=0;i<m.length;i++){
            try{
                x = append(x,m[i][row]);
            }
            catch(Exception e){
                //elegant geht anders
            }
        }
        return x;
        
    }

    /**
     * Ihr habt alle die Artemis-Aufgabe gesehen.
     * @param a Matrix
     * @return "geflipte Matrix"
     * Funktioniert natürlich auch nur mit gleichmäßigen.
     */
    public static int[][] transpose(int[][] a) {
		int[][] re = new int[a[0].length][a.length];

		for(int i=0; i<a.length;i++){
			for(int j=0; j<a[i].length;j++){
				re[j][i] = a[i][j];
			}
		}


		return re;
	}

    /**
     * Macht eine Matrix gleichmäßig, parameter sind die gleichen wie resize
     * @param matrix
     * @param length
     * @param fill
     */
    public static void makeEven(int[][] matrix, int length, int fill){
        for(int i =0;i<matrix.length;i++){
            matrix[i] = resize(matrix[i],length,fill);
        }
    }

    public static int[][] copyOf(int[][] a){
        int[][] newi = new int[a.length][];
        for(int i=0;i<a.length;i++){
            newi[i] = a[i];
        }
        return newi;

    }


    /**
     * Linearisiert eine Matrix, ihr habt alle die Aufgaben gemacht
     * @param a
     * @return
     */
    public static int[] linearize(int[][] a) {
		int len = 0;
		for (int i=0;i<a.length;i++){
			len = len + a[i].length;
		}


		int[] lin = new int[len];
		int cc = 0;

		for (int j = 0;j<a.length;j++){
			for (int k = 0; k<a[j].length;k++){
				lin[cc] = a[j][k];
				cc++;
			}
		}

		return lin;
	}

    /*
     * ###MATRIX MERGE###
     * 
     * Methoden die Matrizen zusammenfügen
     */

    /**
     * Mergt zwei Matrizen
     * @param a
     * @param b
     * @return
     */
   public static int[][] merge(int[][] a, int[][] b){
    int[][] arr = new int[a.length+b.length][];
    int cc = 0;
    for (int i=0;i<a.length;i++){
        arr[cc] = a[i];
        cc++;
    }
    for (int j=0;j<b.length;j++){
        arr[cc] = b[j];
        cc++;
    }

    return arr;
}

    /**
     * Fügt eine Matrix und ein array als vertikale zusammen {[1],[2]} und [3] zu {[1],[2],[3]}
     * Synonym: append
     * @param b
     * @param c
     * @return
     */
    public static int[][] mergeVert(int[][] b, int[] c){
        int[][] arr = new int[b.length+1][];
        for(int i=0;i<b.length;i++){
            arr[i] = b[i];
        }
        arr[arr.length-1] = c;

        return arr;
    }

    public static int[][] append(int[][] b, int[] c){
        return mergeVert(b, c);
    }

    /**
     * Fügt eine Matrix und ein Array als horizontale zusammen {[1],[2]} und [3,4] zu {[1,3],[2,4]}
     * @param b
     * @param c
     * @return
     */
    public static int[][] mergeHori(int[][] b, int[] c){
        int cur = 0;
        int[][] d = copyOf(b);
        for (int i=0;i<c.length;i++){
            d[i] = append(d[i],c[cur]);
            cur++;
        }

        return d;
    }
 

    /*
     * ###TUPLE ZEUGS###
     * Seltsame Methoden die dir Variationen des Arrays zurückgeben. Ignorieren solange man nicht weiß was man tut.
     */

     public static int[][] getAllTuples(int[] a, int num) {
        if (num <= 0 || a.length < num) {
            return new int[0][];
        }

        int totalTuples = (int) power(a.length, num);
        int[][] result = new int[totalTuples][num];

        for (int i = 0; i < totalTuples; i++) {
            int[] tuple = new int[num];
            int temp = i;
            for (int j = 0; j < num; j++) {
                tuple[j] = a[temp % a.length];
                temp /= a.length;
            }
            result[i] = tuple;
        }

        return result;
    }

    public static int[][] getAllUnrepeatingTuples(int[] a, int num) {
        int[][] e = getAllTuples(a, num);

        A: while(true){
        for (int i=0;i<e.length;i++){
            if (!(isDistinct(e[i]))){
                deleteIndex(e, i);
                continue A;
            }
        }
        break A;
        }
        return e;
    }

    public static boolean isDistinct(int[] a){
        for(int i=0;i<a.length;i++){
            if(indexesOf(a,a[i]).length > 1){
                return false;
            }
        }
        return true;

    }

    public static int[][] getAllDistinctTuples(int[] a, int num) {
        int[][] e = getAllTuples(a, num);

        for(int i=0;i<a.length;i++){
            sortAsc(e[i]);
        }

        A: while(true){
        for (int i=0;i<e.length;i++){
            if (!(isDoubled(e,i))){
                deleteIndex(e, i);
                continue A;
            }
        }
        break A;
        }
        return e;
    }

    public static boolean isDoubled(int[][] matrix, int index){
        int[] a = matrix[index];

        for(int i=0;i<matrix.length;i++){
            if (equals(a, matrix[i]) && i != index){
                return false;
            }
        }
        return true;
    }




    /*
     * ###MATHE HILFSMETHODEN###
     * Mathe Hilfsmethoden.
     */


     
    public static int power(int base, int exponent){
        int p = 1;
        for(int i=0;i<exponent;i++){
            p *= base;
        }
        return p;
    }
}
