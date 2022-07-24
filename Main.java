import java.util.*;
public class Main
{
	public static void main(String[] args) {
		int arr[][] = new int[][]{{1,11},{200,250},{217,350}};
	
        Arrays.sort(arr, (a,b)->a[0]-b[0]);
        int k = 59;
        //merge the Arrays
        
        Stack<int[]> st = new Stack<>();
        
        st.push(arr[0]);
        
        for(int i=1;i<arr.length;i++)
        {
            int dusrafirst = arr[i][0];
            int dusrasecond = arr[i][1];
            
            int temp[] = st.pop();
            
            int pahilafirst = temp[0];
            int pahilasecond = temp[1];
            
            if(pahilasecond>=dusrafirst)
            {
                temp[0] = Math.min(pahilafirst,dusrafirst);
                temp[1] = Math.max(pahilasecond,dusrasecond);
                st.push(temp);
            }else{
                st.push(temp);
                st.push(arr[i]);
            }
            
        }

        int [][]output = new int[st.size()][2];
        
        for(int i=output.length-1;i>=0;i--)
        {
            int []temp = st.pop();
            output[i][0] = temp[0];
            output[i][1] = temp[1];
        }
        
        for(int i=0;i<output.length;i++)
        {
            System.out.println(Arrays.toString(output[i]));
        }
        
        
        //--------------------------------------------------
        // find the kth smallest element  
       for(int i=0;i<output.length;i++)
        {
           int first = output[i][0];
           int second = output[i][1];
           
           int total = second-first+1;
           
           if(total<k)
           {
               k = k-total;
           }else{
               System.out.println(first+k-1);
               break;
           }
        }
		
	}
}
