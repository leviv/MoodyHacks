public class HuffmanTree {
    
    private HuffNode root;

    public HuffmanTree(Map<Integer, String) chunksAndCodes) { 
        root = new HuffNode;
        root.freq = -1;
        
        for (int key : chunksAndCodes.keySet) {
            addChunk(key, chunksAndCodes.get(key));
        } 
    }
    
    
    /* pre: root != null, all chars in code are '0' or '1',
     no chunk with code is in this tree yet.
     Add chunk to the tree adding other nodes and links as necessary.
    */ 
    private void addChunk(int chunk, String code) {
        
        HuffNode nodeTrack = root;
        
        for (int i = 0; i < code.length(); i++) {
            char curChar = code.charAt(i);
            
            if (curChar == 0) {
                if (nodeTrack.leftChild == null) {
                    nodeTrack.leftChild = new HuffNode;
                    nodeTrack.leftChild.frequency = -1;
                } 
                nodeTrack = nodeTrack.leftChild;
            } else {
                if (nodeTrack.rightChild == null) {
                    nodeTrack.rightChild = new HuffNode;
                    nodeTrack.rightChild.frequency = -1;
                } 
            
                nodeTrack = nodeTrack.rightChild;
            }
        }
        
        nodeTrack.chunk = chunk;
        
        
    }
    
    private boolean isComplete() {
        assert root != null;
        return completeHelper(root);
    }
        
    private boolean completeHelper(HuffNode n) { 
        if (n == null) {
            return true;
        }
        
        if ((n.leftChild == null && n.rightChild == null)) {
            return true;
        }
        
        if ((n.leftChild != null && n.rightChild != null)) {
            return completeHelper(n.leftChild) && completeHelper(n.rightChild);
        } else {
            return false;
        }        
    }
}

public class Graph {
    // used to indicate a vertex has not been visited and
    // that no path exists between current start vertex.
    private static final double INFINITY = Double.MAX_VALUE;
    private Map<String, Vertex> vertices;
    
    
    private static class Vertex {

        private String name;
        private List<Edge> adjacent;
        private int scratch;
        private double distance;

        public void reset() {
            distance = INFINITY;
            prev = null;
            scratch = 0;
        }
    }

    // model edge between two vertices
    private static class Edge {
        private Vertex dest;
        private double cost;
    }
    
    // calls the reset method on every vertex in this Graph.
    private void clearAll();
    // returns true if this Graph contains a vertex with the
    // given name.
    public boolean containsVertex(String name);
    
    /* pre: containsVertex(start) == true
     post: return true if the vertex specified by start is part
     of a cycle, false otherwise.
    */
    
    public boolean partOfCycle(String start) {
         assert containsVertex(start);
         clearAll(); // do not change this line of code 
        
        Vertex startVertex = vertices.get(start);
        help(startVertex, new HashMap<String>(), start);
    }
    
    public boolean help(Vertex v, HashMap<String> visited, String tgt) {
        
        if (visited.containsKey(v.name)) {
            return false;
        }
        
        visited.put(v.name);
        
        if (v.name == tgt) {
            return true;
        }
        
        for (Edge e : v.adjacent) {
            if (help(e.dest, visited, tgt)) {
                return true
            }
        }
        
        return false
    }
        
}
    

