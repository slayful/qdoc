package com.wikia.qdoc.services.qdoc.editor;

public interface QdocEditorService {

  void updateContent(Qdoc qdoc, String newTitle, String newContent);

  class Qdoc {}
}
