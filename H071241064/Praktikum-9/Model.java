package javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.util.ArrayList;

public class Model extends Application {
    private Stage primaryStage;
    private User currentUser;
    private File selectedImageFile;
    private File profileImageFile;
    private GridPane postGrid = new GridPane();
    private ArrayList<Post> posts = new ArrayList<>();
    private final int POSTS_PER_ROW = 3;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showRegisterScene();
    }

    private void showRegisterScene() {
        BorderPane root = new BorderPane();
        Label header = new Label("MyMoment");
        header.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;");
        StackPane headerPane = new StackPane(header);
        headerPane.setStyle("-fx-background-color: #4f4f4f;");
        headerPane.setPadding(new Insets(10));
        root.setTop(headerPane);

        Label title = new Label("Input User Account");
        title.setStyle("-fx-font-size: 14px;");
        Label nickLabel = new Label("Nick Name");
        TextField nickField = new TextField();
        Label fullLabel = new Label("Full Name");
        TextField fullField = new TextField();

        Button uploadBtn = new Button("Upload Foto Profil");
        ImageView profilePreview = new ImageView();
        profilePreview.setFitWidth(120);
        profilePreview.setFitHeight(120);
        Circle clip = new Circle(60, 60, 60);
        profilePreview.setClip(clip);

        uploadBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            profileImageFile = fileChooser.showOpenDialog(primaryStage);
            if (profileImageFile != null) {
                Image img = new Image(profileImageFile.toURI().toString());
                profilePreview.setImage(img);
            }
        });

        Button registerBtn = new Button("Submit");
        registerBtn.setOnAction(e -> {
            String nick = nickField.getText();
            String full = fullField.getText();
            if (!nick.isEmpty() && !full.isEmpty() && profileImageFile != null) {
                currentUser = new User(nick, full, new Image(profileImageFile.toURI().toString()));
                showHomeScene();
            } else {
                showAlert("Please fill all fields and upload a profile image.");
            }
        });

        VBox center = new VBox(10, title, nickLabel, nickField, fullLabel, fullField, uploadBtn, profilePreview, registerBtn);
        center.setPadding(new Insets(20));
        center.setAlignment(Pos.CENTER);
        root.setCenter(center);

        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Register");
        primaryStage.show();
    }

    private void showHomeScene() {
        BorderPane root = new BorderPane();
        Label header = new Label("MyMoment");
        header.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;");
        StackPane headerPane = new StackPane(header);
        headerPane.setStyle("-fx-background-color: #4f4f4f;");
        headerPane.setPadding(new Insets(10));

        Circle clip = new Circle(50, 50, 50);
        ImageView profileView = new ImageView(currentUser.profileImage);
        profileView.setFitWidth(100);
        profileView.setFitHeight(100);
        profileView.setClip(clip);
        Label nickLabel = new Label(currentUser.nickName);
        Label fullLabel = new Label(currentUser.fullName);
        VBox nameBox = new VBox(5, nickLabel, fullLabel);
        nameBox.setAlignment(Pos.CENTER_LEFT);

        Button addPostBtn = new Button("Add Post");
        HBox infoBox = new HBox(10, profileView, nameBox, addPostBtn);
        infoBox.setAlignment(Pos.CENTER_LEFT);
        infoBox.setPadding(new Insets(10));
        infoBox.setSpacing(20);

        Separator separator = new Separator();
        VBox topBox = new VBox(infoBox, separator);
        root.setTop(new VBox(headerPane, topBox));

        postGrid = new GridPane();
        postGrid.setHgap(10);
        postGrid.setVgap(10);
        postGrid.setPadding(new Insets(10));

        int row = 0, col = 0;
        for (Post post : posts) {
            addPostToGrid(post, row, col);
            col++;
            if (col == POSTS_PER_ROW) {
                col = 0;
                row++;
            }
        }

        ScrollPane scrollPane = new ScrollPane(postGrid);
        scrollPane.setFitToWidth(true);
        root.setCenter(scrollPane);

        addPostBtn.setOnAction(e -> showUploadPostScene());

        Scene scene = new Scene(root, 485, 500);
        primaryStage.setScene(scene);
    }

    private void showUploadPostScene() {
        BorderPane root = new BorderPane();
        Label header = new Label("Upload Post");
        header.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: white;");
        StackPane headerPane = new StackPane(header);
        headerPane.setStyle("-fx-background-color: #4f4f4f;");
        headerPane.setPadding(new Insets(10));
        root.setTop(headerPane);

        Button uploadImageBtn = new Button("Upload Image");
        ImageView previewImageView = new ImageView();
        previewImageView.setFitWidth(250);
        previewImageView.setFitHeight(250);

        Label captionLabel = new Label("Caption");
        TextField captionField = new TextField();
        Button submitBtn = new Button("Submit");

        uploadImageBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            selectedImageFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedImageFile != null) {
                previewImageView.setImage(new Image(selectedImageFile.toURI().toString()));
            }
        });

        submitBtn.setOnAction(e -> {
            String caption = captionField.getText();
            if (selectedImageFile != null && !caption.isEmpty()) {
                Image image = new Image(selectedImageFile.toURI().toString());
                Post post = new Post(image, caption);
                posts.add(post);
                selectedImageFile = null;
                captionField.clear();
                showHomeScene();
            } else {
                showAlert("Please select an image and enter a caption.");
            }
        });

        VBox centerBox = new VBox(10, uploadImageBtn, previewImageView, captionLabel, captionField, submitBtn);
        centerBox.setPadding(new Insets(20));
        centerBox.setAlignment(Pos.CENTER);
        root.setCenter(centerBox);

        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
    }

    private void addPostToGrid(Post post, int row, int col) {
        if (post.image != null) {
            ImageView imageView = new ImageView(post.image);
            imageView.setFitWidth(150);
            imageView.setFitHeight(150);
            imageView.setPreserveRatio(false);
            Tooltip.install(imageView, new Tooltip(post.caption));
            imageView.setOnMouseClicked(e -> showImagePopup(post));
            postGrid.add(imageView, col, row);
        }
    }

    private void showImagePopup(Post post) {
        Stage popupStage = new Stage();
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.setAlignment(Pos.CENTER);
        ImageView imageView = new ImageView(post.image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(400);
        imageView.setFitHeight(400);
        Label captionLabel = new Label(post.caption);
        captionLabel.setStyle("-fx-font-size: 14px; -fx-font-weight: bold;");
        layout.getChildren().addAll(imageView, captionLabel);
        Scene scene = new Scene(layout);
        popupStage.setTitle("Post Detail");
        popupStage.setScene(scene);
        popupStage.show();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        alert.showAndWait();
    }

    class User {
        String nickName;
        String fullName;
        Image profileImage;

        User(String nickName, String fullName, Image profileImage) {
            this.nickName = nickName;
            this.fullName = fullName;
            this.profileImage = profileImage;
        }
    }

    class Post {
        Image image;
        String caption;

        Post(Image image, String caption) {
            this.image = image;
            this.caption = caption;
        }
    }
}