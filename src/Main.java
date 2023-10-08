import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        List< List< Integer > > graph = new ArrayList<>();
        List< List< Integer > > originalGraph = new ArrayList<>();

        System.out.println("Podaj nazwę pliku w którym znajduje się graf w formie listy następników");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();

        System.out.println("Wczytywanie grafu z pliku " + filename);
        loadGraph(graph, filename);

        System.out.println("Wyświetlanie grafu");
        displayGraph(graph);

    }

    public static void loadGraph(List< List< Integer > > graph, String filename) {
        try (BufferedReader br = new BufferedReader( new FileReader("graphs/" + filename + ".txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(line);
                List <Integer> row = new ArrayList<>();

                while (tokenizer.hasMoreTokens()) {
                    row.add(Integer.parseInt(tokenizer.nextToken()));
                }

                graph.add(row);
            }

            System.out.println("Wczytano");
        } catch (IOException e) {
            System.out.println("Nie można otworzyć pliku");
        }
    }

    public static void displayGraph(List< List< Integer > > graph) {
        for(List< Integer > row : graph) {
            for(Integer value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}


