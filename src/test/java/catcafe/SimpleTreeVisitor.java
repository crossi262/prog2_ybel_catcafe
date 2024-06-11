package catcafe;

import tree.Empty;
import tree.Node;
import tree.TreeVisitor;

/**
 * Simple TreeVisitor implementation for testing.
 */
public class SimpleTreeVisitor implements TreeVisitor<FelineOverLord> {

    @Override
    public String visit(Empty<FelineOverLord> node) {
        return "Visited an empty node";
    }

    @Override
    public String visit(Node<FelineOverLord> node) {
        return "Visited a node with data: " + node.data().toString();
    }
}
