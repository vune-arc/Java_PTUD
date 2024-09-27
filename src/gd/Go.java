package gd;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.formdev.flatlaf.util.UIScale;


public class Go extends JLayeredPane{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Menu menu;
	private JPanel panelBody;
	private JButton menuButton;
	public Go() {
		setLayout(new MainFormLayout());
		panelBody = new JPanel(new BorderLayout());
		
		menu=new Menu();
		initMenuArrowIcon();
		menuButton.putClientProperty(FlatClientProperties.STYLE,
				"" + "background:$Menu.button.background;" + "arc:999;" + "focusWidth:0;" + "borderWidth:0");
		menuButton.addActionListener((ActionEvent e) -> {
			setMenuFull(!menu.isMenuFull());
		});
		
		setLayer(menuButton, JLayeredPane.POPUP_LAYER);
		add(menuButton);
		add(menu);
//		panelBody.add(new JLabel("Giao diện"));
//		panelBody.add(new JTextField("Giao diện"));
		KhachHang_GUI kh= new KhachHang_GUI();
		JPanel pe= new JPanel();
		pe.setPreferredSize(new Dimension(20,20));
		panelBody.add(pe,BorderLayout.WEST);
		panelBody.add(kh,BorderLayout.CENTER);
		add(panelBody);
	}
	private void setMenuFull(boolean full) {
		String icon;
		if (getComponentOrientation().isLeftToRight()) {
			icon = (full) ? "menu_left.svg" : "menu_right.svg";
		} else {
			icon = (full) ? "menu_right.svg" : "menu_left.svg";
		}
		menuButton.setIcon(new FlatSVGIcon("icon/" + icon, 0.8f));
		menu.setMenuFull(full);
		revalidate();
		repaint();
	}
	private void initMenuArrowIcon() {
		if (menuButton == null) {
			menuButton = new JButton();
		}
		String icon = (getComponentOrientation().isLeftToRight()) ? "menu_left.svg" : "menu_right.svg";
		menuButton.setIcon(new FlatSVGIcon("icon/" + icon, 0.8f));
	}
	private class MainFormLayout implements LayoutManager {

		@Override
		public void addLayoutComponent(String name, Component comp) {
		}

		@Override
		public void removeLayoutComponent(Component comp) {
		}

		@Override
		public Dimension preferredLayoutSize(Container parent) {
			synchronized (parent.getTreeLock()) {
				return new Dimension(5, 5);
			}
		}

		@Override
		public Dimension minimumLayoutSize(Container parent) {
			synchronized (parent.getTreeLock()) {
				return new Dimension(0, 0);
			}
		}

		@Override
		public void layoutContainer(Container parent) {
			synchronized (parent.getTreeLock()) {
				boolean ltr = parent.getComponentOrientation().isLeftToRight();
				Insets insets = UIScale.scale(parent.getInsets());
				int x = insets.left;
				int y = insets.top;
				int width = parent.getWidth() - (insets.left + insets.right);
				int height = parent.getHeight() - (insets.top + insets.bottom);
				int menuWidth = UIScale.scale(menu.isMenuFull() ? menu.getMenuMaxWidth() : menu.getMenuMinWidth());
				int menuX = ltr ? x : x + width - menuWidth;
				menu.setBounds(menuX, y, menuWidth, height);
				int menuButtonWidth = menuButton.getPreferredSize().width;
				int menuButtonHeight = menuButton.getPreferredSize().height;
				int menubX;
				if (ltr) {
					menubX = (int) (x + menuWidth - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.3f)));
				} else {
					menubX = (int) (menuX - (menuButtonWidth * (menu.isMenuFull() ? 0.5f : 0.7f)));
				}
				menuButton.setBounds(menubX, UIScale.scale(30), menuButtonWidth, menuButtonHeight);
				int gap = UIScale.scale(5);
				int bodyWidth = width - menuWidth - gap;
				int bodyHeight = height;
				int bodyx = ltr ? (x + menuWidth + gap) : x;
				int bodyy = y;
				panelBody.setBounds(bodyx, bodyy, bodyWidth, bodyHeight);
			}
		}
	}
}
