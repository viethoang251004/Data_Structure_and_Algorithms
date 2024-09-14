import java.util.*;
import java.io.*;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new File("input.txt"));
        int vertices = scanner.nextInt();
        AdjacencyMatrix adjacencyMatrix = new AdjacencyMatrix(vertices);

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                adjacencyMatrix.setEgde(i, j, scanner.nextInt());
            }
        }

        scanner.close();

        // (a)
        System.out.println("Adjacency Matrix:");
        adjacencyMatrix.printGraph();
        // (b)
        System.out.println("Number of Vertices: " + adjacencyMatrix.getNumberOfVertices());
        // (c)
        System.out.println("Number of Edges: " + adjacencyMatrix.getNumberOfEdges());
        // (d)
        int vertexToEnumerate = 0;
        List<Integer> neighbors = adjacencyMatrix.getNeighbors(vertexToEnumerate);
        System.out.println("Neighbors of vertex " + vertexToEnumerate + ": " + neighbors);
        // (e)
        int u = 0; // Replace with the source vertex
        int v = 1; // Replace with the destination vertex

        boolean edgeExists = adjacencyMatrix.edgeExists(u, v);
        System.out.println("Edge (" + u + ", " + v + ") exists: " + edgeExists);
    }
}


// import java.io.*;
// class Test
// {
//     AdjacencyMatrix a;

//     //Doc file
//     public Test(String filename)
//     {
//         try
//         {
//             FileReader fr=new FileReader(filename);    
//             BufferedReader br=new BufferedReader(fr); 
//             String s = br.readLine();
//             a = new AdjacencyMatrix(Integer.parseInt(s));
            
//             String[] t;
//             for(int i = 0; i<a.NUMBER_OF_VERTICES; ++i)
//             {
//                 s = br.readLine();
//                 t = s.split(" ");
//                 for(int j = 0; j< t.length; ++j)
//                     a.setEgde(i, j, Integer.parseInt(t[j]));;
//             }
//             br.close();
//             fr.close();
//         }catch(Exception e)
//         {
//             System.out.println(e);
//         }
//     }
//     public static void main(String[] arg)
//     {
//         Test t = new Test("input.txt");
//         t.a.printGraph();
//         t.a.BFS(0);
//         System.out.println();
//         t.a.DFS(0);
//         System.out.println();

//     }
// }