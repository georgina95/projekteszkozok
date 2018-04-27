package reportService.model;

@NoArgsConstructor
@AllArgsConstructor
public class Key {
    public int id;
    public Report report;

    public int getId() {
        return id;
    }

    public Report getReport() {
        return report;
    }
}