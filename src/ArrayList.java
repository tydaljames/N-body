public class ArrayList<E> implements List<E> {
    public int size = 0;
    public E[]arr = null;


public ArrayList(){  //Constructor
    arr = (E[]) new Object[10];
}

    public E get (int pos) {  //Get item from ArrayList
        if (pos < 0 || pos >= size) {
            throw new ArrayIndexOutOfBoundsException("Invalid position");
        }
        return arr[pos];
    }


    public boolean add(E item) { //Add item to ArrayList
        if (size == arr.length) {
            grow();
        }
        arr[size++] = item;
        return true;

    }

    public void add(int pos, E item){ //Add item to ArrayList at index
        for(int i=size;i>pos;i--){
            arr[i] = arr[i-1];
        }
        arr[pos] = item;
        ++size;
    }


    private void grow(){ //Increase ArrayList size if needed
        E [] new_arr = (E[]) new Object[arr.length * 2];
        for(int i=0;i<arr.length;i++){
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }



        public E remove(int pos){ //Remove item from ArrayList at index
            if(pos<0 || pos>size){
                return null;
            }
            else{
                E temp = arr[pos-1];
                for(int i=pos;i<size-1;i++){
                    arr[i-1] = arr[i];
                }
                size--;
                return temp;
            }
        }


    public int size(){ //Return number of items in the ArrayList
        return size;
    }
}
