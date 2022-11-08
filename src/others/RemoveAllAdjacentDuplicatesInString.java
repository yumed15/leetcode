package others;

import java.util.Stack;

class Node
{
    char c;
    int count;
    Node(char c, int count)
    {
        this.c = c;
        this.count = count;
    }
}

public class RemoveAllAdjacentDuplicatesInString {

        public String removeDuplicates(String s, int k) {
            Stack<Node> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++)
            {
                if (stack.size() == 0) // stack is empty
                {
                    stack.push(new Node(s.charAt(i), 1));
                }
                else // stack is not empty
                {
                    Node prev = stack.peek();
                    if (prev.c == s.charAt(i))
                    {
                        stack.push(new Node(s.charAt(i), prev.count + 1));
                        if (stack.peek().count == k) // if we encounter k adjacent characters, then remove them
                        {
                            for (int j = 0; j < k; j++)
                            {
                                stack.pop();
                            }
                        }
                    }
                    else
                    {
                        stack.push(new Node(s.charAt(i), 1));
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while(stack.size() != 0) sb.append(stack.pop().c);
            sb.reverse();
            return sb.toString();
        }

}


//    public String removeDuplicates(String s, int k) {
//        boolean done;
//
//        do{
//            done = true;
//            int count = 1;
//            for(int i=0; i<s.length()-1; i++) {
//                if(s.charAt(i) == s.charAt(i+1))
//                    count++;
//                else
//                    count = 1;
//                if(count == k) {
//                    int index_1 = i+1-k+1;
//                    int index_2 = i+1;
//
//                    s = s.substring(0, index_1) + s.substring(index_2+1);
//                    done = false;
//                    break;
//                }
//            }
//            System.out.println(s);
//        }while(!done);
//
//        return s;
//    }
