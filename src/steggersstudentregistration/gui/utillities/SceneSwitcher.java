package steggersstudentregistration.gui.utillities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class SceneSwitcher {

    /**
     * Creates a 'SceneControllerBag' that contnains a Scene and the matching Controller.
     *
     * @param pathToView The path to the scene.
     * @param <T>        The Controller T
     * @return A SceneControllerBag object conatining both the scene and controller.
     * @throws IOException
     */
    public <T> SceneControllerBag getSceneControllerBag(String pathToView) throws IOException {
        URL url = getClass().getResource(pathToView);
        System.out.println(url);
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        T controller = loader.getController();
        return new SceneControllerBag(root, controller);
    }

    /**
     * Creates a new scene in a new stage.
     *
     * @param pathToView The path to the view file.
     * @param <T>        The type of controller associated with the view.
     * @return The newly created views controller.
     * @throws IOException
     */
    public <T> T putSceneInStageNGetController(String pathToView) throws IOException {
        Stage stage = new Stage();
        return putSceneInStageNGetController(pathToView, stage);
    }

    /**
     * Creates a new scene in the given Stage.
     *
     * @param pathToView The path to the view file.
     * @param stage      The stage to add the Scene to.
     * @param <T>        The controller associated with the view.
     * @return The newly created views controller.
     * @throws IOException
     */
    public <T> T putSceneInStageNGetController(String pathToView, Stage stage) throws IOException {
        SceneControllerBag scb = getSceneControllerBag(pathToView);
        Scene scene = new Scene(scb.getRoot());
        stage.setScene(scene);
        return (T) scb.controller;
    }

    public class SceneControllerBag<V> {
        private final Parent root;
        private final V controller;

        public SceneControllerBag(Parent root, V controller) {
            this.controller = controller;
            this.root = root;
        }

        public Parent getRoot() {
            return root;
        }

        public V getController() {
            return controller;
        }
    }

}