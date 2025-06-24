package gradle1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private User currentUser = new User();
    private List<Post> posts = new ArrayList<>();
    private GridPane postGrid = new GridPane();
    private ImageView profilePreview; 

    @Override
    public void start(Stage primaryStage) {
        VBox registerRoot = new VBox(15);
        registerRoot.setPadding(new Insets(20));
        registerRoot.setAlignment(Pos.CENTER);

        Label titleLabel = new Label("Input User Account");

        Label nickNameLabel = new Label("Nick Name");
        TextField nickNameField = new TextField();

        Label fullNameLabel = new Label("Full Name");
        TextField fullNameField = new TextField();

        profilePreview = new ImageView();
        profilePreview.setFitHeight(100);
        profilePreview.setFitWidth(100);
        Circle circle = new Circle(50, 50, 50);
        profilePreview.setClip(circle);

        Button profileImageButton = new Button("Upload Foto Profil");
        profileImageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                currentUser.setProfileImagePath(selectedFile.getAbsolutePath());
                Image img = new Image("file:" + selectedFile.getAbsolutePath());
                profilePreview.setImage(img);
            }
        });

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            currentUser.setNickName(nickNameField.getText());
            currentUser.setFullName(fullNameField.getText());
            showHomeScene(primaryStage);
        });

        registerRoot.getChildren().addAll(
            titleLabel,
            nickNameLabel, nickNameField,
            fullNameLabel, fullNameField,
            profileImageButton,
            profilePreview,
            submitButton
        );

        Scene registerScene = new Scene(registerRoot, 400, 500);
        primaryStage.setTitle("MyMoment");
        primaryStage.setScene(registerScene);
        primaryStage.show();
    }

    public void showHomeScene(Stage primaryStage) {
        VBox homeRoot = new VBox(20);
        homeRoot.setPadding(new Insets(15));

        HBox profileBox = new HBox(15);
        profileBox.setAlignment(Pos.CENTER_LEFT);

        if (currentUser.getProfileImagePath() != null) {
            Image profileImage = new Image("file:" + currentUser.getProfileImagePath());
            ImageView profileImageView = new ImageView(profileImage);
            profileImageView.setFitHeight(100);
            profileImageView.setFitWidth(100);
            Circle circle = new Circle(50, 50, 50);
            profileImageView.setClip(circle);
            profileBox.getChildren().add(profileImageView);
        }

        VBox nameBox = new VBox(5);
        Label nameLabel = new Label(currentUser.getNickName());
        Label fullNameLabel = new Label(currentUser.getFullName());
        nameBox.getChildren().addAll(nameLabel, fullNameLabel);

        Button uploadPostButton = new Button("Add Post");
        uploadPostButton.setOnAction(e -> uploadPost(primaryStage));
        nameBox.getChildren().add(uploadPostButton);

        profileBox.getChildren().add(nameBox);

        // Post grid
        postGrid = new GridPane();
        postGrid.setPadding(new Insets(10));
        postGrid.setHgap(15);
        postGrid.setVgap(15);

        displayPosts();

        homeRoot.getChildren().addAll(profileBox, new Separator(), postGrid);

        Scene homeScene = new Scene(homeRoot, 500, 600);
        primaryStage.setTitle("MyMoment");
        primaryStage.setScene(homeScene);
    }

    private void uploadPost(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            Image postImage = new Image("file:" + selectedFile.getAbsolutePath());
            ImageView previewImageView = new ImageView(postImage);
            previewImageView.setFitWidth(200);
            previewImageView.setFitHeight(200);

            TextField captionField = new TextField("Caption here...");
            Button submitPostButton = new Button("Submit Post");

            VBox postForm = new VBox(10, previewImageView, captionField, submitPostButton);
            postForm.setPadding(new Insets(10));
            postForm.setAlignment(Pos.CENTER);

            Scene postScene = new Scene(postForm, 300, 350);
            Stage postStage = new Stage();
            postStage.setScene(postScene);
            postStage.setTitle("New Post");
            postStage.show();

            submitPostButton.setOnAction(e -> {
                Post post = new Post();
                post.setCaption(captionField.getText());
                post.setPostImagePath(selectedFile.getAbsolutePath());
                posts.add(post);
                postStage.close();
                displayPosts();
            });
        }
    }

    private void displayPosts() {
        postGrid.getChildren().clear();
        int col = 0, row = 0;
        for (Post post : posts) {
            Image image = new Image("file:" + post.getPostImagePath());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(150);
            imageView.setFitHeight(150);

            Label caption = new Label(post.getCaption());
            caption.setBackground(new Background(new BackgroundFill(Color.rgb(0, 0, 0, 0.6), null, null)));
            caption.setTextFill(Color.WHITE);
            caption.setVisible(false);

            StackPane postPane = new StackPane(imageView, caption);
            postPane.setOnMouseEntered(e -> caption.setVisible(true));
            postPane.setOnMouseExited(e -> caption.setVisible(false));
            postPane.setOnMouseClicked(e -> showFullImage(image));

            postGrid.add(postPane, col, row);
            col++;
            if (col >= 3) {
                col = 0;
                row++;
            }
        }
    }

    private void showFullImage(Image image) {
        Stage fullStage = new Stage();
        ImageView imageView = new ImageView(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(500);
        imageView.setFitHeight(500);

        StackPane root = new StackPane(imageView);
        root.setStyle("-fx-background-color: black");

        Scene scene = new Scene(root, 520, 520);
        fullStage.setScene(scene);
        fullStage.setTitle("Full Image");
        fullStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
