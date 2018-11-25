package com.company;

import java.util.ArrayList;

public class Sequence {
    private ArrayList<Statement> statements;

    public Sequence() {
        statements = new ArrayList<Statement>();
    }

    public void addToSequence(Statement statement) {
        statements.add(statement);
    }

    public ArrayList<Statement> GetStatements() {
        return statements;
    }

    public Statement getStatementAtPosition(int position){
        return statements.get(position);
    }
}