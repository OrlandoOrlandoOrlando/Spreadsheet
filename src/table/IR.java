package table;

import java.util.HashMap;

abstract class IR implements Format {
    private Table table = new Table();

    protected void setTable(int row, int column, String value) {
        table.HEADS.put(new Table.Index(row, column), new Table.ImmCell(value));
    }

    // TODO use reflection in 'to' definition
    // void requireNoArgConstructor() {}
    // public <T extends IR> T to(Class<T> clazz) {
    //     return null;
    // }

}

class Table {
    final HashMap<Index, Head> HEADS = new HashMap<>();

    record Index(int row, int column) {}

    interface Head {
        public String getValue();
    }

    interface Cell extends Head {
        @Override
        public int hashCode();
    }

    record ImmCell(String value) implements Cell {
        @Override
        public String getValue() { return value; }
    }

    record MutCell(StringBuilder sb) implements Cell {
        public MutCell(String value) {
            this(new StringBuilder(value));
        }

        @Override
        public String getValue() { return sb.toString(); }

    }

    class Chain implements Head {
        String value;
        Linkage root;

        @Override
        public String getValue() { return value; }

        class Linkage {
            String value;
        }

        class Link extends Linkage {
            Linkage next;
        }

        class DoubleLink extends Linkage {
            Linkage down, right;
        }

    }

}
