import java.util.*;

public class LibraryDSAProject {

    static String[] books = {
            "Data Structures",
            "Algorithms",
            "Operating Systems",
            "Computer Networks",
            "Database Systems",
            "Artificial Intelligence",
            "Machine Learning",
            "Java Programming"
    };

    static Stack<String> stack = new Stack<>();
    static Queue<String> queue = new LinkedList<>();
    static HashMap<String,Integer> hash = new HashMap<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();

    // Linear Search
    static int linearSearch(String key) {
        for(int i=0;i<books.length;i++){
            if(books[i].equalsIgnoreCase(key))
                return i;
        }
        return -1;
    }

    // Binary Search
    static int binarySearch(String key){
        String[] arr = books.clone();
        Arrays.sort(arr);

        int low=0,high=arr.length-1;

        while(low<=high){

            int mid=(low+high)/2;

            int cmp = arr[mid].compareToIgnoreCase(key);

            if(cmp==0)
                return mid;

            if(cmp<0)
                low=mid+1;
            else
                high=mid-1;
        }

        return -1;
    }

    // Bubble Sort
    static void bubbleSort(){

        String[] arr=books.clone();

        for(int i=0;i<arr.length;i++){

            for(int j=0;j<arr.length-i-1;j++){

                if(arr[j].compareTo(arr[j+1])>0){

                    String temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;

                }

            }

        }

        System.out.println(Arrays.toString(arr));
    }

    // Insertion Sort
    static void insertionSort(){

        String[] arr=books.clone();

        for(int i=1;i<arr.length;i++){

            String key=arr[i];
            int j=i-1;

            while(j>=0 && arr[j].compareTo(key)>0){

                arr[j+1]=arr[j];
                j--;

            }

            arr[j+1]=key;

        }

        System.out.println(Arrays.toString(arr));
    }

    // Selection Sort
    static void selectionSort(){

        String[] arr=books.clone();

        for(int i=0;i<arr.length;i++){

            int min=i;

            for(int j=i+1;j<arr.length;j++){

                if(arr[j].compareTo(arr[min])<0)
                    min=j;

            }

            String temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;

        }

        System.out.println(Arrays.toString(arr));
    }

    // Stack operations
    static void pushBook(String b){
        stack.push(b);
        System.out.println("Pushed: "+b);
    }

    static void popBook(){
        if(stack.isEmpty())
            System.out.println("Stack Empty");
        else
            System.out.println("Popped: "+stack.pop());
    }

    // Queue operations
    static void enqueueBook(String b){
        queue.add(b);
        System.out.println("Added: "+b);
    }

    static void dequeueBook(){
        if(queue.isEmpty())
            System.out.println("Queue Empty");
        else
            System.out.println("Removed: "+queue.poll());
    }

    // Hash table
    static void buildHash(){
        for(int i=0;i<books.length;i++)
            hash.put(books[i],i);
    }

    static void hashSearch(String b){
        if(hash.containsKey(b))
            System.out.println("Book Found");
        else
            System.out.println("Book Not Found");
    }

    // Priority Queue
    static void addPriority(String b){
        pq.add(b);
    }

    static void removePriority(){
        if(pq.isEmpty())
            System.out.println("Empty");
        else
            System.out.println("Next: "+pq.poll());
    }

    // Balance symbols
    static boolean isBalanced(String expr){

        Stack<Character> st=new Stack<>();

        for(char ch:expr.toCharArray()){

            if(ch=='(' || ch=='{' || ch=='[')
                st.push(ch);

            if(ch==')' || ch=='}' || ch==']'){

                if(st.isEmpty())
                    return false;

                char open=st.pop();

                if(ch==')' && open!='(') return false;
                if(ch=='}' && open!='{') return false;
                if(ch==']' && open!='[') return false;

            }

        }

        return st.isEmpty();
    }

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        buildHash();

        while(true){

            System.out.println("\nLibrary Book Quest Portal");
            System.out.println("1 Linear Search");
            System.out.println("2 Binary Search");
            System.out.println("3 Bubble Sort");
            System.out.println("4 Insertion Sort");
            System.out.println("5 Selection Sort");
            System.out.println("6 Stack");
            System.out.println("7 Queue");
            System.out.println("8 Hash Search");
            System.out.println("9 Priority Queue");
            System.out.println("10 Balance Symbols");
            System.out.println("0 Exit");

            int ch=Integer.parseInt(sc.nextLine());

            switch(ch){

                case 1:
                    System.out.print("Book: ");
                    System.out.println("Index: "+linearSearch(sc.nextLine()));
                    break;

                case 2:
                    System.out.print("Book: ");
                    System.out.println("Index: "+binarySearch(sc.nextLine()));
                    break;

                case 3:
                    bubbleSort();
                    break;

                case 4:
                    insertionSort();
                    break;

                case 5:
                    selectionSort();
                    break;

                case 6:
                    pushBook("NewBook");
                    popBook();
                    break;

                case 7:
                    enqueueBook("Book1");
                    dequeueBook();
                    break;

                case 8:
                    System.out.print("Book: ");
                    hashSearch(sc.nextLine());
                    break;

                case 9:
                    addPriority("UrgentBook");
                    removePriority();
                    break;

                case 10:
                    System.out.print("Expression: ");
                    System.out.println(isBalanced(sc.nextLine()));
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Invalid");

            }

        }

    }

}