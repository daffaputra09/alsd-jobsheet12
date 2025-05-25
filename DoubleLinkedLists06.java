public class DoubleLinkedLists06 {
    Node06 head;
    Node06 tail;

    public DoubleLinkedLists06() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(Mahasiswa06 data) {
        Node06 newNode = new Node06(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    public void addLast(Mahasiswa06 data) {
        Node06 newNode = new Node06(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void insertAfter(String keyNim, Mahasiswa06 data) {
        Node06 current = head;
        
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan.");
            return;
        }

        Node06 newNode = new Node06(data);
        
        if (current == tail) {
            current.next = newNode;
            newNode.prev = current;
            tail = newNode;
        } else {
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }

        System.out.println("Node berhasil disisipkan setelah NIM " + keyNim);
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Linked list masih kosong!");
        } else {
            Node06 tmp = head;
            System.out.println("Data Mahasiswa:");
            while (tmp != null) {
                tmp.data.tampil();
                tmp = tmp.next;
            }
        }
    }

    public Node06 search(String nim) {
        Node06 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }

        Mahasiswa06 tmp = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah:");
        tmp.tampil();
    }

    public void removeLast() {
        if (isEmpty()) {
            System.out.println("List kosong, tidak bisa dihapus.");
            return;
        }
        
        Mahasiswa06 tmp = tail.data;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        System.out.println("Data sudah berhasil dihapus. Data yang terhapus adalah:");
        tmp.tampil();
    }

    public void add(Mahasiswa06 data, int index) {
        if (index < 0) {
            System.out.println("Indeks tidak valid!");
            return;
        }

        if (index == 0) {
            addFirst(data);
            return;
        }

        Node06 current = head;
        int i = 0;
        while (i < index - 1 && current != null) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Indeks melebihi panjang linked list!");
            return;
        }

        if (current == tail) {
            addLast(data);
            return;
        }

        Node06 newNode = new Node06(data);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        System.out.println("Data berhasil ditambahkan pada indeks " + index);
    }
    
    public void removeAfter(String keyNim) {
        if (isEmpty()) {
            System.out.println("List kosong!");
            return;
        }

        Node06 current = head;
        while (current != null && !current.data.nim.equals(keyNim)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node dengan NIM " + keyNim + " tidak ditemukan!");
            return;
        }

        if (current.next == null) {
            System.out.println("Tidak ada node setelah node dengan NIM " + keyNim);
            return;
        }

        Mahasiswa06 tmp = current.next.data;
        if (current.next == tail) {
            current.next = null;
            tail = current;
        } else {
            current.next = current.next.next;
            current.next.prev = current;
        }
        
        System.out.println("Data berhasil dihapus. Data yang terhapus adalah:");
        tmp.tampil();
    }

    public void remove(int index) {
        if (isEmpty()) {
            System.out.println("List kosong!");
            return;
        }

        if (index < 0) {
            System.out.println("Indeks tidak valid!");
            return;
        }

        if (index == 0) {
            removeFirst();
            return;
        }

        Node06 current = head;
        int i = 0;
        while (i < index && current != null) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Indeks melebihi panjang linked list!");
            return;
        }

        Mahasiswa06 tmp = current.data;
        if (current == tail) {
            removeLast();
            return;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        System.out.println("Data berhasil dihapus. Data yang terhapus adalah:");
        tmp.tampil();
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("Linked List kosong!");
            return;
        }
        System.out.println("Data mahasiswa di posisi awal:");
        head.data.tampil();
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("Linked List kosong!");
            return;
        }
        System.out.println("Data mahasiswa di posisi akhir:");
        tail.data.tampil();
    }

    public void getIndex(int index) {
        if (isEmpty()) {
            System.out.println("Linked List kosong!");
            return;
        }

        if (index < 0) {
            System.out.println("Indeks tidak valid!");
            return;
        }

        Node06 current = head;
        int i = 0;
        while (i < index && current != null) {
            current = current.next;
            i++;
        }

        if (current == null) {
            System.out.println("Indeks melebihi panjang linked list!");
            return;
        }

        System.out.println("Data mahasiswa di indeks ke-" + index + ":");
        current.data.tampil();
    }
}