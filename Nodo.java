 class Nodo {
        private int info;
        private Nodo enlace;

        public Nodo(int info) {
            this.info = info;
            this.enlace = null;
        }

        public Nodo(int info, Nodo enlace) {
            this.info = info;
            this.enlace = enlace;
        }

        public void setInfo(int info) {
            this.info = info;
        }

        public int getInfo() {
            return this.info;
        }

        public void setEnlace(Nodo enlace) { // COn el setEnlace se unen los nodos
            this.enlace = enlace;
        }

        public Nodo getEnlace() {
            return this.enlace;
        }
    }