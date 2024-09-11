package com.google.appinventor.components.runtime.util;

import com.google.appinventor.components.common.FileScope;
import com.google.appinventor.components.runtime.Component;
import com.google.appinventor.components.runtime.Form;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class CompositeFileOperation extends FileOperation implements Iterable<FileOperand> {
    private final List<FileOperand> DmQGLROFyZ9Eo0RSsJcpZNxJZjgcsPDfYPi3awNwmyyErT71sGU5mvgG4PDW3yL = new ArrayList();
    private boolean R6I3TvhVUzjImNcsZnPIarNQNa08KFL5suF8ZyHVabZqiWX3lxOTmOWImMG2ChIe = false;
    private final Set<String> permissions = new HashSet();

    /* access modifiers changed from: protected */
    public abstract void performOperation();

    public static class FileOperand {
        /* access modifiers changed from: private */
        public final String T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq;
        private final FileAccessMode hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;

        FileOperand(String str, FileAccessMode fileAccessMode) {
            this.T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq = str;
            this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME = fileAccessMode;
        }

        public String getFile() {
            return this.T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq;
        }

        public FileAccessMode getMode() {
            return this.hxYOFxFjLpN1maJuWNxUV40nExCGxsxkDPOTgtzMu4zlZCQb3bPlKsXo1SYJg6ME;
        }
    }

    public CompositeFileOperation(Form form, Component component, String str, boolean z) {
        super(form, component, str, z);
    }

    public void addFile(FileScope fileScope, String str, FileAccessMode fileAccessMode) {
        FileOperand fileOperand = new FileOperand(FileUtil.resolveFileName(this.form, str, fileScope), fileAccessMode);
        this.DmQGLROFyZ9Eo0RSsJcpZNxJZjgcsPDfYPi3awNwmyyErT71sGU5mvgG4PDW3yL.add(fileOperand);
        this.permissions.add(FileUtil.getNeededPermission(this.form, str, fileAccessMode));
        this.R6I3TvhVUzjImNcsZnPIarNQNa08KFL5suF8ZyHVabZqiWX3lxOTmOWImMG2ChIe |= FileUtil.isExternalStorageUri(this.form, fileOperand.T3TEUSUxjrJVucuujQ9pjstrX3UcxHV1L9cOGs7CI5pfz9hjmRfdL7GRyW8ebdVq);
    }

    public List<String> getPermissions() {
        return new ArrayList(this.permissions);
    }

    /* access modifiers changed from: protected */
    public boolean needsExternalStorage() {
        return this.R6I3TvhVUzjImNcsZnPIarNQNa08KFL5suF8ZyHVabZqiWX3lxOTmOWImMG2ChIe;
    }

    public Iterator<FileOperand> iterator() {
        return this.DmQGLROFyZ9Eo0RSsJcpZNxJZjgcsPDfYPi3awNwmyyErT71sGU5mvgG4PDW3yL.iterator();
    }
}
