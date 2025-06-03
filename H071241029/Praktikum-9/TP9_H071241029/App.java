package gradle_javafx;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
       private User currentUser;
       private List<Post> posts = new ArrayList<>();
       private HBox postContainer = new HBox(10);

       @Override
       public void start(Stage primaryStage) {
              primaryStage.setTitle("MyMoment");
              // SCENE REGISTER
              Label title = new Label("INPUT USER ACCOUNT");
              title.setFont(Font.font("Arial", 20));

              TextField nickNameField = new TextField();
              nickNameField.setPromptText("Nick Name");
              nickNameField.setMaxWidth(300);

              TextField fullNameField = new TextField();
              fullNameField.setPromptText("Full Name");
              fullNameField.setMaxWidth(300);

              ImageView profilePreview = new ImageView();
              profilePreview.setFitWidth(120);
              profilePreview.setFitHeight(120);
              Circle clip = new Circle(60, 60, 60);
              profilePreview.setClip(clip);

              Button uploadProfileBtn = new Button("Upload Foto Profil");
              FileChooser profileFileChooser = new FileChooser();
              profileFileChooser.setTitle("Pilih Foto Profil");

              uploadProfileBtn.setOnAction(e -> {
                     File file = profileFileChooser.showOpenDialog(primaryStage);
                     if (file != null) {
                     Image image = new Image(file.toURI().toString());
                     profilePreview.setImage(image);
                     }
              });

              Button submitBtn = new Button("Submit");

              VBox form = new VBox(10, nickNameField, fullNameField, uploadProfileBtn, profilePreview, submitBtn);
              form.setAlignment(Pos.CENTER);

              VBox registerRoot = new VBox(20, title, form);
              registerRoot.setPadding(new Insets(20));
              registerRoot.setAlignment(Pos.TOP_CENTER);

              Scene registerScene = new Scene(registerRoot, 400, 500);
              // SCENE HOME
              VBox homeRoot = new VBox(15);
              homeRoot.setPadding(new Insets(20));
              homeRoot.setAlignment(Pos.TOP_CENTER);

              HBox profileBox = new HBox(15);
              profileBox.setAlignment(Pos.CENTER_LEFT);

              ImageView homeProfile = new ImageView();
              homeProfile.setFitWidth(120);
              homeProfile.setFitHeight(120);
              homeProfile.setClip(new Circle(60, 60, 60));

              VBox identityBox = new VBox();
              identityBox.setSpacing(5);
              Label nameLabel = new Label();
              Label fullLabel = new Label();
              nameLabel.setFont(Font.font("Arial", 16));
              fullLabel.setFont(Font.font("Arial", 14));

              identityBox.getChildren().addAll(nameLabel, fullLabel);
              Button addPostBtn = new Button("Add Post");
              profileBox.getChildren().addAll(homeProfile, identityBox, addPostBtn);

              postContainer.setPadding(new Insets(10));
              postContainer.setAlignment(Pos.TOP_CENTER);

              ScrollPane scrollPane = new ScrollPane(postContainer);
              scrollPane.setFitToWidth(true);
              scrollPane.setPrefHeight(350);

              homeRoot.getChildren().addAll(profileBox, new Separator(), scrollPane);
              Scene homeScene = new Scene(homeRoot, 500, 600);
              // ACTION SUBMIT
              submitBtn.setOnAction(e -> {
                     String nick = nickNameField.getText();
                     String full = fullNameField.getText();
                     Image img = profilePreview.getImage();
                     if (!nick.isEmpty() && !full.isEmpty() && img != null) {
                            currentUser = new User(nick, full, img);
                            nameLabel.setText(currentUser.getNickName());
                            fullLabel.setText(currentUser.getFullName());
                            homeProfile.setImage(currentUser.getProfileImage());
                            primaryStage.setScene(homeScene);
                     }
              });

              addPostBtn.setOnAction(e -> openPostWindow());
              primaryStage.setScene(registerScene);
              primaryStage.show();
       }

       private void openPostWindow() {
              Stage postStage = new Stage();
              postStage.initModality(Modality.APPLICATION_MODAL);
              postStage.setTitle("Upload post");

              VBox layout = new VBox(10);
              layout.setPadding(new Insets(20));
              layout.setAlignment(Pos.CENTER);

              Button uploadImageBtn = new Button("Upload Image");
              ImageView postImageView = new ImageView();
              postImageView.setFitWidth(250);
              postImageView.setPreserveRatio(true);

              TextField captionField = new TextField();
              captionField.setPromptText("Caption");

              FileChooser fileChooser = new FileChooser();
              fileChooser.setTitle("Pilih Gambar");

              uploadImageBtn.setOnAction(e -> {
                     File file = fileChooser.showOpenDialog(postStage);
                     if (file != null) {
                            Image img = new Image(file.toURI().toString());
                            postImageView.setImage(img);
                     }
              });

              Button submitPostBtn = new Button("Submit");
              submitPostBtn.setOnAction(e -> {
                     Image img = postImageView.getImage();
                     String caption = captionField.getText();
                     if (img != null && caption != null && !caption.isEmpty()) {
                            Post post = new Post(img, caption);
                            posts.add(post);
                            addPostToHome(post);
                            postStage.close();
                     }
              });

              layout.getChildren().addAll(uploadImageBtn, postImageView, new Label("Caption"), captionField, submitPostBtn);

              Scene scene = new Scene(layout, 300, 400);
              postStage.setScene(scene);
              postStage.show();
       }

       private void addPostToHome(Post post) {
              StackPane imagePane = new StackPane();
              ImageView imageView = new ImageView(post.getPostImage());
              imageView.setFitWidth(140);
              imageView.setPreserveRatio(true);
              imageView.setSmooth(true);

              Label caption = new Label(post.getCaption());
              caption.setTextFill(Color.WHITE);
              caption.setStyle("-fx-font-size: 16px; -fx-background-color: rgba(0, 0, 0, 0.5); -fx-padding: 5;");
              caption.setVisible(false);

              imagePane.getChildren().addAll(imageView, caption);

              imagePane.setOnMouseEntered((MouseEvent e) -> caption.setVisible(true));
              imagePane.setOnMouseExited((MouseEvent e) -> caption.setVisible(false));

              imagePane.setOnMouseClicked(e -> previewImage(post.getPostImage()));

              postContainer.getChildren().add(imagePane);
       }

       private void previewImage(Image image) {
              Stage previewStage = new Stage();
              previewStage.initModality(Modality.APPLICATION_MODAL);
              previewStage.setTitle("Preview Gambar");

              ImageView imageView = new ImageView(image);
              imageView.setPreserveRatio(true);
              imageView.setFitWidth(400);

              HBox box = new HBox(imageView);
              box.setAlignment(Pos.CENTER);
              box.setPadding(new Insets(20));

              Scene scene = new Scene(box);
              previewStage.setScene(scene);
              previewStage.show();
       }

       public static void main(String[] args) {
              launch(args);
       }
}

class User {
       private String nickName;
       private String fullName;
       private Image profileImage;

       public User(String nickName, String fullName, Image profileImage) {
              this.nickName = nickName;
              this.fullName = fullName;
              this.profileImage = profileImage;
       }

       public String getNickName() { return nickName; }
       public String getFullName() { return fullName; }
       public Image getProfileImage() { return profileImage; }
}

class Post {
       private Image postImage;
       private String caption;

       public Post(Image postImage, String caption) {
              this.postImage = postImage;
              this.caption = caption;
       }

       public Image getPostImage() { return postImage; }
       public String getCaption() { return caption; }
}

//./gradlew run --continuous (Ctrl+D buat close)