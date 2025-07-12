@Entity
public class CartItem {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Product product;

  @ManyToOne
  private User user;

  private int quantity;
}
