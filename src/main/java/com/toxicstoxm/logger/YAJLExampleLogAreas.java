package com.toxicstoxm.logger;

import com.toxicstoxm.YAJL.areas.LogAreaBundle;
import com.toxicstoxm.YAJL.areas.YAJLLogArea;

import java.awt.*;
import java.util.List;

public class YAJLExampleLogAreas implements LogAreaBundle {

    public static class UNDEFINED extends YAJLLogArea {
        public UNDEFINED() {
            super(new Color(140,140,140));
        }
    }

    public static class GENERAL extends YAJLLogArea {
        public GENERAL() {
            super(new Color(255,255,255));
        }
    }

    public static class UI extends YAJLLogArea {
        public UI() {
            super(new Color(255,80,80));
        }
    }

    public static class WINDOW extends YAJLLogArea {
        public WINDOW() {
            super(new Color(255, 0, 0), List.of("UI"));
        }
    }

    public static class NETWORK extends YAJLLogArea {
        public NETWORK() {
            super(new Color(54, 193, 8));
        }
    }

    public static class UI_NETWORK_BRIDGE extends YAJLLogArea {
        public UI_NETWORK_BRIDGE() {
            super(new Color(2, 253, 217), List.of("UI", "WINDOW"));
        }
    }

    public static class CONFIG extends YAJLLogArea {
        public CONFIG() {
            super(new Color(255, 198, 0));
        }
    }

}
