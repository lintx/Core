package com.iCo6;

import java.io.File;
import java.util.List;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;


public class Constants {
    public static enum Nodes {
        Currency("System.Default.Currency", "");

        String node;
        Object value;

        private Nodes(String node, Object value) {
            this.node = node;
            this.value = value;
        }

        public String getNode() {
            return node;
        }

        public Object getValue() {
            return this.value;
        }

        public Boolean getBoolean() {
            return (Boolean) value;
        }

        public Integer getInteger() {
            if(value instanceof Double)
                return ((Double) value).intValue();

            return (Integer) value;
        }

        public Double getDouble() {
            if(value instanceof Integer)
                return (double) ((Integer) value).intValue();

            return (Double) value;
        }

        public Long getLong() {
            if(value instanceof Integer)
                return ((Integer) value).longValue();

            return (Long) value;
        }

        public List<String> getStringList() {
            return (List<String>) value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    public static void load(File configuration) {
        FileConfiguration config = YamlConfiguration.loadConfiguration(configuration);

        for(Nodes n: Nodes.values())
            if(!n.getNode().isEmpty())
                if(config.get(n.getNode()) != null)
                    n.setValue(config.get(n.getNode()));
    }
}
