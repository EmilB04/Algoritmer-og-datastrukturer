import java.util.*;

public class App
{
   public static void main(String[] args)
   {
      Queue<Character> queue = new LinkedList<>();
      String line;
      Scanner in = new Scanner(System.in);

      System.out.print("? ");
      line = in.nextLine();
      in.close();

      for (int i = 0; i < line.length(); i++)
         queue.add(line.charAt(i));

      while (!queue.isEmpty())
         System.out.print(queue.remove());
         System.out.println();
      }
   }
