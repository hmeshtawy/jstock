/*
 * JStock - Free Stock Market Software
 * Copyright (C) 2011 Yan Cheng CHEOK <yccheok@yahoo.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */

package org.yccheok.jstock.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdesktop.jxlayer.JXLayer;
import org.yccheok.jstock.engine.AjaxYahooSearchEngine;
import org.yccheok.jstock.engine.AjaxYahooSearchEngine.ResultType;
import org.yccheok.jstock.engine.Code;
import org.yccheok.jstock.engine.Observer;
import org.yccheok.jstock.engine.StockInfo;
import org.yccheok.jstock.engine.StockInfoDatabase;
import org.yccheok.jstock.engine.Symbol;
import org.yccheok.jstock.internationalization.GUIBundle;
import org.yccheok.jstock.internationalization.MessagesBundle;

/**
 *
 * @author  yccheok
 */
public class StockDatabaseJDialog extends javax.swing.JDialog {

    /** Creates new form StockDatabaseJDialog */
    public StockDatabaseJDialog(java.awt.Frame parent, StockInfoDatabase stockInfoDatabase, boolean modal) {
        super(parent, modal);
        this.stockInfoDatabase = stockInfoDatabase;
        initComponents();

        initJXLayerOnJComboBox();

        // Focus on our Ajax auto complete JComboBox.
        this.jComboBox1.requestFocus();
        ((AjaxAutoCompleteJComboBox)this.jComboBox1).attachResultObserver(getResultObserver());
        
    }

    // Install JXLayer around JComboBox.
    // It is used to display busy indicator.
    private void initJXLayerOnJComboBox() {
        // Wrap combo box.
        final JXLayer<JComboBox> layer = new JXLayer<JComboBox>(this.jComboBox1);
        // Set our LayerUI.
        JComboBoxLayerUI jComboBoxLayerUI = new JComboBoxLayerUI();
        layer.setUI(jComboBoxLayerUI);
        ((AjaxAutoCompleteJComboBox)this.jComboBox1).attachBusyObserver(jComboBoxLayerUI);
        // Add the layer as usual combo box.
        jPanel5.add(layer);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new AjaxAutoCompleteJComboBox();
        jPanel6 = new javax.swing.JPanel();
        jXHeader1 = new org.jdesktop.swingx.JXHeader();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jComboBox1.setEditable(true);
        jComboBox1.setPreferredSize(new java.awt.Dimension(160, 24));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("org/yccheok/jstock/data/gui"); // NOI18N
        setTitle(bundle.getString("StockDatabaseJDialog_StockDatabase")); // NOI18N
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel6.setLayout(new java.awt.BorderLayout(5, 5));

        jXHeader1.setDescription(bundle.getString("StockDatabaseJDialog_Description")); // NOI18N
        jXHeader1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/64x64/db_add.png"))); // NOI18N
        jXHeader1.setTitle(bundle.getString("StockDatabaseJDialog_StockDatabase")); // NOI18N
        jPanel6.add(jXHeader1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("StockDatabaseJDialog_StockExchangeServer"))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(getSystemDefinedStockInfoTableModel());
        this.jTable1.setDefaultRenderer(Symbol.class, new StockTableCellRenderer());
        this.jTable1.setDefaultRenderer(Code.class, new StockTableCellRenderer());
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jTextField1.setColumns(10);
        jTextField1.getDocument().addDocumentListener(
            new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    newFilter();
                }
                public void insertUpdate(DocumentEvent e) {
                    newFilter();
                }
                public void removeUpdate(DocumentEvent e) {
                    newFilter();
                }
            });
            jPanel3.add(jTextField1);

            jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

            jPanel4.add(jPanel1);

            jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("StockDatabaseJDialog_UserDefined"))); // NOI18N
            jPanel2.setLayout(new java.awt.BorderLayout());

            this.jScrollPane2.addMouseListener(new TableRowPopupListener(true));

            jTable2.setAutoCreateRowSorter(true);
            jTable2.setModel(getUserDefinedStockInfoTableModel());
            this.jTable2.addMouseListener(new TableRowPopupListener());
            this.jTable2.setDefaultRenderer(Code.class, new StockTableCellRenderer());
            this.jTable2.setDefaultRenderer(Symbol.class, new StockTableCellRenderer());
            this.jTable2.setDefaultEditor(Code.class, this.getCellEditor(Code.class));
            this.jTable2.setDefaultEditor(Symbol.class, this.getCellEditor(Symbol.class));
            //this.jTable2.setDefaultEditor(Object.class, this.getSymbolCellEditor());
            jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    jTable2KeyPressed(evt);
                }
            });
            jScrollPane2.setViewportView(jTable2);

            jPanel2.add(jScrollPane2, java.awt.BorderLayout.CENTER);
            jPanel2.add(jPanel5, java.awt.BorderLayout.NORTH);

            jLabel2.setFont(jLabel2.getFont().deriveFont(jLabel2.getFont().getSize()-1f));
            jLabel2.setText(bundle.getString("StockDatabaseJDialog_NeedHelpVisit")); // NOI18N
            jPanel10.add(jLabel2);

            jLabel3.setFont(jLabel3.getFont().deriveFont(jLabel3.getFont().getSize()-1f));
            jLabel3.setText(bundle.getString("StockDatabaseJDialog_HelpURL")); // NOI18N
            jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jLabel3MouseClicked(evt);
                }
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    jLabel3MouseEntered(evt);
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    jLabel3MouseExited(evt);
                }
            });
            jPanel10.add(jLabel3);

            jPanel2.add(jPanel10, java.awt.BorderLayout.SOUTH);

            jPanel4.add(jPanel2);

            getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

            jPanel7.setLayout(new java.awt.BorderLayout());

            jLabel1.setForeground(new java.awt.Color(0, 0, 255));
            jLabel1.setText(getTotalStockString());
            jPanel8.add(jLabel1);

            jPanel7.add(jPanel8, java.awt.BorderLayout.NORTH);

            jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/apply.png"))); // NOI18N
            jButton3.setText(bundle.getString("StockDatabaseJDialog_OK")); // NOI18N
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });
            jPanel9.add(jButton3);

            jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/16x16/button_cancel.png"))); // NOI18N
            jButton4.setText(bundle.getString("StockDatabaseJDialog_Cancel")); // NOI18N
            jButton4.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton4ActionPerformed(evt);
                }
            });
            jPanel9.add(jButton4);

            jPanel7.add(jPanel9, java.awt.BorderLayout.CENTER);

            getContentPane().add(jPanel7, java.awt.BorderLayout.PAGE_END);

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
    // TODO add your handling code here:
        clearAllTablesSelection();
    }//GEN-LAST:event_formMouseClicked

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        if(KeyEvent.VK_DELETE == evt.getKeyCode()) {
            this.deleteSelectedUserDefinedDatabase();
            return;
        }
    }//GEN-LAST:event_jTable2KeyPressed

    public StockInfoDatabase getResult()
    {
        return result;
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // We are no longer interest to receive any event from combo box.
        ((AjaxAutoCompleteJComboBox)this.jComboBox1).dettachAll();
        this.result = null;
        this.setVisible(false);
        this.dispose();    
    }//GEN-LAST:event_jButton4ActionPerformed

    /* OK button being pressed. */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // We are no longer interest to receive any event from combo box.
        ((AjaxAutoCompleteJComboBox)this.jComboBox1).dettachAll();

        // Returns the active cell editor, which is null if the table is not
        // currently editing. 
        final TableCellEditor tableCellEditor = this.jTable2.getCellEditor();
        if (tableCellEditor != null) {
            // Save the value to table model.
            final boolean status = tableCellEditor.stopCellEditing();
            if (false == status) {
                // User enters an invalid value. Prevent user from closing
                // dialog.
                return;
            }
        }

        final StockInfoTableModel model = (StockInfoTableModel)(jTable2.getModel());
        final List<StockInfo> stockInfos = model.getStockInfos();

        /* Shall we check the returned code? */
        this.stockInfoDatabase.removeAllUserDefinedStockInfos();

        for (StockInfo stockInfo : stockInfos) {
            // In fact, we shouldn't need to trim the string again, as
            // MyTableCellEditor has done that for us. The code is here to fix
            // old user-defined-database.xml, with possibility to have data
            // begin and end with white space. This is because old version of
            // JStock (1.0.5r) doesn't perform trimming.
            final String codeStr = stockInfo.code.toString().trim();
            if (codeStr.length() <= 0) {
                continue;
            }
            String symbolStr = stockInfo.symbol.toString().trim();
            if (symbolStr.length() <= 0) {
                /* We allow empty symbol to be entered by user. In 0 length
                 * symbol case, we will make it same as code.
                 */
                symbolStr = codeStr;
            }
            this.stockInfoDatabase.addUserDefinedStockInfo(new StockInfo(Code.newInstance(codeStr), Symbol.newInstance(symbolStr)));
        }

        
        this.result = this.stockInfoDatabase;
        
        this.setVisible(false);
        this.dispose();    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        Utils.launchWebBrowser(org.yccheok.jstock.network.Utils.getURL(org.yccheok.jstock.network.Utils.Type.HELP_STOCK_DATABASE_HTML));
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        this.setCursor(Cursor.getDefaultCursor());
    }//GEN-LAST:event_jLabel3MouseExited

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // We are no longer interest to receive any event from combo box.
        ((AjaxAutoCompleteJComboBox)this.jComboBox1).dettachAll();
        // Stop all threading activities in AjaxAutoCompleteJComboBox.
        ((AjaxAutoCompleteJComboBox)this.jComboBox1).stop();
    }//GEN-LAST:event_formWindowClosed
    
    private class TableRowPopupListener extends MouseAdapter {
        private boolean newMenuItemOnly = false;

        public TableRowPopupListener(boolean newMenuItemOnly) {
            this.newMenuItemOnly = newMenuItemOnly;
        }

        public TableRowPopupListener() {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                getMyJTablePopupMenu(newMenuItemOnly).show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    private static final class StockTableCellRenderer extends javax.swing.table.DefaultTableCellRenderer {
    
        /** Creates a new instance of StockTableCellRender */
        public StockTableCellRenderer() {
            super();
        }

    
        private Color getBackgroundColor(int row) {
            final JStockOptions jStockOptions = MainFrame.getInstance().getJStockOptions();
        
            if (row % 2 == 0) {
                return jStockOptions.getFirstRowBackgroundColor();
            }
        
            return jStockOptions.getSecondRowBackgroundColor();
        }
    
        @Override
        public Component getTableCellRendererComponent(
                                JTable table, Object color,
                                boolean isSelected, boolean hasFocus,
                                int row, int column) {
            Component c = super.getTableCellRendererComponent(table, color, isSelected, hasFocus, row, column);

            if (isSelected || hasFocus) {
                return c;
            }

            final JStockOptions jStockOptions = MainFrame.getInstance().getJStockOptions();
        
            c.setForeground(jStockOptions.getNormalTextForegroundColor());
    
            c.setBackground(getBackgroundColor(row));

            return c;
        }    
    }

    private void deleteSelectedUserDefinedDatabase() {
        int rows[] = jTable2.getSelectedRows();

        final StockInfoTableModel codeSymbolTableModel = (StockInfoTableModel)(jTable2.getModel());
        
        Arrays.sort(rows);

        for (int i = rows.length - 1; i >= 0; i--) {
            int row = rows[i];
            if (row < 0) {
                continue;
            }
            final int modelIndex = jTable2.getRowSorter().convertRowIndexToModel(row);            
            codeSymbolTableModel.removeRow(modelIndex);
        }        
    }
    
    private void clearAllTablesSelection() {
        this.jTable1.getSelectionModel().clearSelection();        
        this.jTable2.getSelectionModel().clearSelection();        
    }
    
    private void selectUserDefinedDatabaseTable(int modelIndex) {
        clearAllTablesSelection();
                
        final int selectedViewIndex = jTable2.getRowSorter().convertRowIndexToView(modelIndex);
        jTable2.getSelectionModel().setSelectionInterval(selectedViewIndex, selectedViewIndex);
        JTableUtilities.scrollToVisible(jTable2, selectedViewIndex, 0);
        
    }
    
    private void selectStockExchangeServerDatabaseTable(int modelIndex) {
        clearAllTablesSelection();
        
        final int selectedViewIndex = jTable1.getRowSorter().convertRowIndexToView(modelIndex);
        jTable1.getSelectionModel().setSelectionInterval(selectedViewIndex, selectedViewIndex);        
        JTableUtilities.scrollToVisible(jTable1, selectedViewIndex, 0);
    }
    
    private void addNewStockInfo()
    {
        final StockInfoTableModel model = (StockInfoTableModel)jTable2.getModel();
        final int selectedModelIndex = model.addNewStockInfo();
        selectUserDefinedDatabaseTable(selectedModelIndex);        
    }

    private void addNewStockInfo(ResultType result) {
        final StockInfoTableModel model = (StockInfoTableModel)jTable2.getModel();
        final int selectedModelIndex = model.addNewStockInfo(result);
        selectUserDefinedDatabaseTable(selectedModelIndex);
    }

    private Observer<AjaxAutoCompleteJComboBox, AjaxYahooSearchEngine.ResultType> getResultObserver() {
        return new Observer<AjaxAutoCompleteJComboBox, AjaxYahooSearchEngine.ResultType>() {
            @Override
            public void update(AjaxAutoCompleteJComboBox subject, ResultType arg) {
                assert(arg != null);
                assert(SwingUtilities.isEventDispatchThread());
                // Ensure arg is in the correct format.
                final ResultType result = org.yccheok.jstock.engine.Utils.rectifyResult(arg);
                if (result == null) {
                    // Invalid format. Nothing we can do about it. Returns
                    // early.
                    return;
                }
                // Check for duplication.
                // Symbol from Yahoo means Code in JStock.
                String message_string = result.symbol;
                IndexEx indexEx = getIndexEx(result.symbol, Code.class);
                if (indexEx == null) {
                    message_string = result.name;
                    // Name from Yahoo means Symbol in JStock.
                    indexEx = getIndexEx(result.name, Symbol.class);
                }
                if (indexEx != null) {
                    if (indexEx.table == jTable1) {
                        selectStockExchangeServerDatabaseTable(indexEx.index);
                    } else {
                        assert(indexEx.table == jTable2);
                        selectUserDefinedDatabaseTable(indexEx.index);
                    }
                    // Warn the user.
                    final String message = MessageFormat.format(MessagesBundle.getString("warning_message_duplicated_stock_template"), message_string);
                    final String title = MessagesBundle.getString("warning_title_duplicated_stock");
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            JOptionPane.showMessageDialog(StockDatabaseJDialog.this, message, title, JOptionPane.INFORMATION_MESSAGE);
                        }
                    });
                    // No thanks! I will ignore the result.
                    return;
                }

                // Everything just looks fine. Let's insert it into the table.
                addNewStockInfo(result);
            }
        };
    }

    private JPopupMenu getMyJTablePopupMenu(boolean newMenuItemOnly) {
        final JPopupMenu popup = new JPopupMenu();
        
        javax.swing.JMenuItem menuItem = new JMenuItem("New", new javax.swing.ImageIcon(getClass().getResource("/images/16x16/filenew.png")));
        
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addNewStockInfo();
            }
        });

        popup.add(menuItem);

        if (newMenuItemOnly) {
            /* Single menu item only. */
            return popup;
        }

        if (jTable2.getSelectedRowCount() >= 1) {
            popup.addSeparator();
            
            menuItem = new JMenuItem("Delete", new javax.swing.ImageIcon(getClass().getResource("/images/16x16/editdelete.png")));

            menuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    deleteSelectedUserDefinedDatabase();
                }
            });  
            
            popup.add(menuItem);            
        }
        
        return popup;
    }

    private TableModel getUserDefinedStockInfoTableModel()
    {
        return new StockInfoTableModel(Type.UserDefined);
    }

    // For jTable1.
    private TableModel getSystemDefinedStockInfoTableModel()
    {
        return new StockInfoTableModel(Type.SystemDefined);
    }

    @SuppressWarnings("unchecked")
    private void newFilter()
    {
        final String text = jTextField1.getText();

        // I really have no idea what the second parameter is.
        final RowFilter<StockInfoTableModel, Integer> rf;
        
        // If current expression doesn't parse, don't update.
        try {
            // (?i) is for case insensitive.
            rf = RowFilter.regexFilter("^(?i)" + Pattern.quote(text));
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }

        if (org.yccheok.jstock.engine.Utils.isPinyinTSTSearchEngineRequiredForSymbol() == false) {
            ((TableRowSorter<StockInfoTableModel>)jTable1.getRowSorter()).setRowFilter(rf);
        } else {
            ((TableRowSorter<StockInfoTableModel>)jTable1.getRowSorter()).setRowFilter(new RowFilter<StockInfoTableModel, Integer>() {

                @Override
                public boolean include(Entry<? extends StockInfoTableModel, ? extends Integer> entry) {
                    // Try regexFilter first.
                    if (rf.include(entry)) {
                        return true;
                    }
                    // Fail. Further try with pinyin. Pinyin is in lower case.
                    final String lower_text = text.toLowerCase();
                    final StockInfoTableModel model = entry.getModel();
                    final Symbol symbol = model.getStockInfos().get(entry.getIdentifier()).symbol;
                    List<String> pinyins = org.yccheok.jstock.gui.Utils.toHanyuPinyin(symbol.toString());
                    for (String pinyin : pinyins) {
                        if (pinyin.startsWith(lower_text)) {
                            return true;
                        }
                    }
                    return false;
                }

            });
        }
    }
    
    /* Use exclusively by CodeSymbolTableModel. */
    /* Unless I make CodeSymbolTableModel as static class, there is no way for
     * me to declare enum type inside CodeSymbolTableModel.
     */
    private enum Type {
        UserDefined,
        SystemDefined
    }

    private class StockInfoTableModel extends AbstractTableModel {
        // For fast access purpose.
        private final List<StockInfo> stockInfos;
        private final Type type;

        public Type getType() {
            return this.type;
        }

        public List<StockInfo> getStockInfos() {
            return Collections.unmodifiableList(stockInfos);
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return !isReadOnly();
        }

        private boolean isReadOnly() {
            return this.type != Type.UserDefined;
        }

        public void removeRow(int index) {
            if (this.isReadOnly()) {
                return;
            }
            this.stockInfos.remove(index);
            this.fireTableRowsDeleted(index, index);
        }

        public StockInfoTableModel(Type type) {
            this.type = type;
            
            if (this.type == Type.UserDefined) {
                stockInfos = StockDatabaseJDialog.this.stockInfoDatabase.getUserDefinedStockInfos();
            }
            else {
                stockInfos = StockDatabaseJDialog.this.stockInfoDatabase.getNonUserDefinedStockInfos();
            }
        }
        
        @Override
        public int getRowCount() {
            return stockInfos.size();
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return stockInfos.get(rowIndex).code;
                case 1:
                    return stockInfos.get(rowIndex).symbol;
            }
            
            return null;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Class getColumnClass(int c) {
            return columnClasses[c];
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            if (this.isReadOnly()) {
                super.setValueAt(value, row, col);
                return;
            }
            if (value instanceof Symbol) {
                final Symbol symbol = (Symbol)value;
                final Code code = stockInfos.remove(row).code;
                stockInfos.add(row, new StockInfo(code, symbol));
            }
            else if (value instanceof Code) {
                final Code code = (Code)value;
                final Symbol symbol = stockInfos.remove(row).symbol;
                stockInfos.add(row, new StockInfo(code, symbol));
            }
            else {
                assert(false);
            }
            fireTableCellUpdated(row, col);
        }

        // Make it as case-insensitive comparison.
        public int findStockInfoBySymbol(String string) {
            int index = -1;
            for (int i = 0, size = stockInfos.size(); i < size; i++) {
                if (stockInfos.get(i).symbol.toString().equalsIgnoreCase(string)) {
                    index = i;
                    break;
                }
            }
            return index;
        }

        // Make it as case-insensitive comparison.
        public int findStockInfoByCode(String string) {
            int index = -1;
            for (int i = 0, size = stockInfos.size(); i < size; i++) {
                if (stockInfos.get(i).code.toString().equalsIgnoreCase(string)) {
                    index = i;
                    break;
                }
            }
            return index;
        }

        public int addNewStockInfo() {
            final Code code = Code.newInstance("");
            final Symbol symbol = Symbol.newInstance("");
            this.stockInfos.add(new StockInfo(code, symbol));

            final int index = this.stockInfos.size() - 1;
            this.fireTableRowsInserted(index, index);

            return index;
        }

        public int addNewStockInfo(ResultType result) {
            // Symbol from Yahoo means Code in JStock.
            final Code code = Code.newInstance(result.symbol);
            // Name from Yahoo means Symbol in JStock.
            final Symbol symbol = Symbol.newInstance(result.name);
            this.stockInfos.add(new StockInfo(code, symbol));

            final int index = this.stockInfos.size() - 1;
            this.fireTableRowsInserted(index, index);

            return index;
        }

        private final String[] columnNames = {"Code", "Symbol"};
        private final Class[] columnClasses = {Code.class, Symbol.class};
    }

    private TableCellEditor getCellEditor(Class c) {
        return new MyTableCellEditor(c);
    }
            
    private class MyTableCellEditor extends DefaultCellEditor {    
        private final Class c;

        public MyTableCellEditor(Class c) {
            super(new JTextField());
            this.c = c;
        }

        // Override to invoke setValue on the formatted text field.
        @Override
        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected,
                int row, int column) {
            ((JComponent)getComponent()).setBorder(new LineBorder(Color.black));
            return super.getTableCellEditorComponent(table, value, isSelected, row, column);
        }

        // Override to ensure that the value remains an Integer.
        @Override
        public Object getCellEditorValue() {
            JTextField textField = (JTextField)getComponent();
            String str = textField.getText();
            if (str == null) {
                // Possible?
                return null;
            }
            // Remember to trim the string.
            str = str.trim();
            try {
                @SuppressWarnings("unchecked")
                Method method = this.c.getMethod("newInstance", String.class);
                // We will only enforce upper case for Code.
                return method.invoke(null, c == Code.class ? str.toUpperCase() : str);
            } catch (Exception ex) {
                log.error(null, ex);
            }
            return null;
        }

        //Override to check whether the edit is valid,
        //setting the value if it is and complaining if
        //it isn't.  If it's OK for the editor to go
        //away, we need to invoke the superclass's version 
        //of this method so that everything gets cleaned up.
        @Override
        public boolean stopCellEditing() {
            // Remember to trim the string.
            final String string;
            if (c == Code.class) {
                // We will only enforce upper case for Code.
                string = ((String)super.getCellEditorValue()).trim().toUpperCase();
            } else {
                string = ((String)super.getCellEditorValue()).trim();
            }
            
            if (0 == string.length()) {
                // We are not interest to evaluate empty string. Return
                // immediately.
                return super.stopCellEditing();
            }

            final IndexEx indexEx = getIndexEx(string, c);
            if (indexEx != null) {
                if (indexEx.table == jTable2) {
                    if (indexEx.index == jTable2.convertRowIndexToModel(jTable2.getEditingRow())) {
                        // Is me myself lah! Ignore the validation rule.
                        return super.stopCellEditing();
                    }
                }
                
                ((JComponent)getComponent()).setBorder(new LineBorder(Color.red));
                if (indexEx.table == jTable1) {
                    selectStockExchangeServerDatabaseTable(indexEx.index);
                } else {
                    assert(indexEx.table == jTable2);
                    selectUserDefinedDatabaseTable(indexEx.index);
                }
                // Warn the user.
                final String message = MessageFormat.format(MessagesBundle.getString("warning_message_duplicated_stock_template"), string);
                final String title = MessagesBundle.getString("warning_title_duplicated_stock");
                JOptionPane.showMessageDialog(StockDatabaseJDialog.this, message, title, JOptionPane.INFORMATION_MESSAGE);
                return false;
            }

            return super.stopCellEditing();
        }
    }

    private String getTotalStockString() {
        return MessageFormat.format(GUIBundle.getString("StockDatabaseJDialog_TotalStock_template"), stockInfoDatabase.size());
    }

    /**
     * Returns first encountered row index based on the string. <code>null</code>
     * if not found.
     * 
     * @param string The string
     * @param c Code or Symbol class
     * @return first encountered row index based on the string. <code>null</code>
     * if not found
     */
    private IndexEx getIndexEx(String string, Class c) {
        final StockInfoTableModel model1 = (StockInfoTableModel)(StockDatabaseJDialog.this.jTable1.getModel());
        /*
         * Shall we have a strict duplicated detection rule, (Do not allow a
         * newly inserted string to be same as Code or Symbol, regardless which
         * column it is from)
         *
         * Or, shall we have a loosen duplicated detection rule? (Do not allow
         * a newly inserted string to be same as its type).
         */
        final int modelIndex1 = Code.class == c ? model1.findStockInfoByCode(string) : model1.findStockInfoBySymbol(string);
        if (modelIndex1 >= 0) {
            return IndexEx.newInstance(modelIndex1, jTable1);
        }

        // Perform further checking.
        final StockInfoTableModel model2 = (StockInfoTableModel)(StockDatabaseJDialog.this.jTable2.getModel());
        final int modelIndex2 = Code.class == c ? model2.findStockInfoByCode(string) : model2.findStockInfoBySymbol(string);
        if (modelIndex2 >= 0) {
            return IndexEx.newInstance(modelIndex2, jTable2);
        }

        // Not found.
        return null;
    }

    /**
     * Carry 2 information, which are index, and table.
     */
    private static class IndexEx {
        private IndexEx(int index, JTable table) {
            this.index = index;
            this.table = table;
        }

        public static IndexEx newInstance(int index, JTable table) {
            return new IndexEx(index, table);
        }

        public final int index;
        public final JTable table;
    }

    private final StockInfoDatabase stockInfoDatabase;
    private StockInfoDatabase result = null;
    
    private static final Log log = LogFactory.getLog(StockDatabaseJDialog.class);
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private org.jdesktop.swingx.JXHeader jXHeader1;
    // End of variables declaration//GEN-END:variables

}
