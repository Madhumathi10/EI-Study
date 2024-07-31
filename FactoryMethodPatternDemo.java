// Document interface
interface Document {
    String createDocument();
}

// Concrete documents
class TextDocument implements Document {
    @Override
    public String createDocument() {
        return "Text Document Created";
    }
}

class SpreadsheetDocument implements Document {
    @Override
    public String createDocument() {
        return "Spreadsheet Document Created";
    }
}

// DocumentFactory interface
interface DocumentFactory {
    Document createDocument();
}

// Concrete factories
class TextDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new TextDocument();
    }
}

class SpreadsheetDocumentFactory implements DocumentFactory {
    @Override
    public Document createDocument() {
        return new SpreadsheetDocument();
    }
}

// Usage
public class FactoryMethodPatternDemo {
    public static void main(String[] args) {
        DocumentFactory textFactory = new TextDocumentFactory();
        DocumentFactory spreadsheetFactory = new SpreadsheetDocumentFactory();

        Document textDoc = textFactory.createDocument();
        Document spreadsheetDoc = spreadsheetFactory.createDocument();

        System.out.println(textDoc.createDocument());
        System.out.println(spreadsheetDoc.createDocument());
    }
}
