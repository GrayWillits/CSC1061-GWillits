package edu.frcc.csc1061j.GettingToPhilosophy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    /**
     * Tests a conjecture about Wikipedia and Philosophy.
     *
     * https://en.wikipedia.org/wiki/Wikipedia:Getting_to_Philosophy
     *
     * 1. Clicking on the first non-parenthesized, non-italicized link
     * 2. Ignoring external links, links to the current page, or red links
     * 3. Stopping when reaching "Philosophy", a page with no links or a page
     *    that does not exist, or when a loop occurs
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        testConjecture(destination, source, 20);
        
        for (String site: visited) {
        	System.out.println(site);
        }
        
        if (visited.contains(destination)) {
        	System.out.println("\n\nSuccess");
        }
        else {
        	System.out.println("\n\nFailure");
        }
    }

    /**
     * Starts from given URL and follows first link until it finds the destination or exceeds the limit.
     *
     * @param destination
     * @param source
     * @throws IOException
     */
    public static void testConjecture(String destination, String source, int limit) throws IOException {
    	visited.add(source);
    	if (limit <= 0) {
    		return;
    	}
    	if (source.equals(destination)) {
    		return;
    	}
    	
        Document doc = null;
        Connection conn = Jsoup.connect(source);
        try 
        {
            doc = conn.get();
        }
        catch (Exception e)
        {
            System.out.println("Could not open page. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }

        // select the content text and pull out the paragraphs.
        Element content = doc.getElementById("mw-content-text");
        Elements paragraphs = content.select("p");

        for (Element para : paragraphs) {
            Iterable<Node> iter = new WikiNodeIterable(para);
            Stack<String> paren = new Stack<String>();
            for (Node node : iter) {
            	if (node.toString().contains("(") && node.toString().charAt(0) != '<') {
            		String temp = new String(node.toString());
            		for (int i = 0; i < node.toString().length() - (new String(node.toString())).replace("(", "").length(); i++) {
            			paren.push("(");
            		}
            	}
            	if (node.toString().contains(")") && node.toString().charAt(0) != '<') {
            		for (int i = 0; i < node.toString().length() - (new String(node.toString())).replace(")", "").length(); i++) {
            			paren.pop();
            		}
            	}
            	
            	if (paren.size() == 0 && node.toString().length() > 1 && node.toString().charAt(0) == '<' && node.toString().charAt(1) == 'a' && node.toString().contains("href")) {
            		String path = node.toString().split("\"")[1];
            		if (path.charAt(0) != '#' && !visited.contains("https://en.wikipedia.org" + path)) {
            			testConjecture(destination, ("https://en.wikipedia.org" + path), limit -1 );
            			return;
            		}
            	}
                
                // TODO: FILL THIS IN!
            	
            	
            	// If this node is a text node make sure you are not within parentheses
            	
            	// If this node has a link you can get it by accessing the href attribute in the node
            	
            	// If the link is not null and not an empty string and does not start with a # sign 
            	// and is not within parentheses, follow the link recursively by calling testConjecture() 
            	// until you reach your objective or run past the limit. 
            }

        }
    }
}
