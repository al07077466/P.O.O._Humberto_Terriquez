package edu.humberto.terriquez.actividades.actividad3.models;

/**
 * Product es la clase encargada de definir los atributos y comportamientos de los productos de una tienda.
 * Contiene los atributos name, description, code, type, price y tax, incluyendo sus setters y sus getters.
 */
public class Product {
    private String name;
    private String description;
    private String code;
    private String type;
    private double price;
    private double tax;

    /**
     * Constructor encargado de inicializar un producto. Recibiendo:
     * @param name
     * @param description
     * @param code
     * @param type
     * @param price
     * @param tax
     */
    public Product(String name, String description, String code, String type, double price, double tax) {
        setName(name);
        setDescription(description);
        setCode(code);
        setType(type);
        setPrice(price);
        setTax(tax);
    }

    /**
     * Getters.
     */
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCode() { return code; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public double getTax() { return tax; }

    /**
     * Setters con sus validaciones de exepciones.
     */
    public void setName(String name) {
        if (name.matches(".*\\d.*") && name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede contener números o estar vacio.");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description.isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede estar vacía.");
        }
        this.description = description;
    }

    public void setCode(String code) {
        if (!code.matches("\\d{10}")) {
            throw new IllegalArgumentException("El código debe contener exactamente 10 números.");
        }
        this.code = code;
    }

    public void setType(String type) {
        if (type.isEmpty()) {
            throw new IllegalArgumentException("El tipo de producto no puede estar vacío.");
        }
        this.type = type;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }
        this.price = price;
    }

    public void setTax(double tax) {
        if (tax < 0) {
            throw new IllegalArgumentException("El impuesto no puede ser negativo.");
        }
        this.tax = tax;
    }
}