@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public String userProfile(Model model, Principal principal) {
        // Get currently logged-in user
        String username = principal.getName();
        User user = userRepository.findByUsername(username);

        model.addAttribute("user", user);
        return "profile";  // profile.html
    }
}
