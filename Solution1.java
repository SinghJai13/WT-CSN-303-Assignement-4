import java.util.*;
public class Solution1 {

	public static void main(String[] args) {
		try {
		int n, m;
        Scanner input=new Scanner(System.in);
        n= input.nextInt();
        m= input.nextInt();
        input.nextLine(); 
        String[] crops = new String[n];
        for (int i=0;i<n;i++)
        {
            crops[i]=input.nextLine().trim();
        }
        input.close();
        char[][] plot = new char[n][m];
        for(int i=0; i<n; i++)
        {
            for(int j=0;j<m; j++)
            {
                plot[i][j] = crops[i].charAt(j);
            }
        }
        char[] types = new char[26];
        for(char c='a'; c<'z'; c++)
        {
            types[c-'a'] = c;
        }
        System.out.println(replant(plot, 0, 0, n, m, 0, n*m, types));
		}
		catch(Exception e)
		{
			System.out.println("Error Occured  .");
		}
	}

    //curr= cur
	public static int replant(char[][] plot, int curr_row, int curr_col, int n, int m, int curr_count, int minm_count, char[] types)
    {
        Set<Character> left_up = new HashSet<Character>();
        if(curr_row!=0)
        {
            left_up.add(plot[curr_row-1][curr_col]);
        }
        if(curr_col!=0)
        {
            left_up.add(plot[curr_row][curr_col-1]);
        }
        Set<Character> right_down = new HashSet<Character>();
        if(curr_row!=n-1)
        {
            right_down.add(plot[curr_row+1][curr_col]);
        }
        if(curr_col!=m-1)
        {
            right_down.add(plot[curr_row][curr_col+1]);
        }
        boolean present_left_up = false;
        if(left_up.contains(plot[curr_row][curr_col]))
        {
            present_left_up = true;
        }
        char[][] new_crops_mat = new char[n][m];
        if(right_down.contains(plot[curr_row][curr_col]))
        {
            if(present_left_up)
            {
                for(int k=0; k<26; k++)
                {
                    if(!left_up.contains(types[k]) && !right_down.contains(types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                new_crops_mat[i][j] = plot[i][j];
                            }
                        }
                        new_crops_mat[curr_row][curr_col] = types[k];
                        if(curr_col<m-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row, curr_col+1, n, m, curr_count+1, minm_count, types));
                        }
                        else if(curr_row<n-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row+1, 0, n, m, curr_count+1, minm_count, types));
                        }
                        else
                        {
                            return Math.min(curr_count+1, minm_count);
                        }
                        break;
                    }
                }
            }
            else
            {
                if(curr_col<m-1)
                {
                    minm_count = Math.min(minm_count, replant(plot, curr_row, curr_col+1, n, m, curr_count, minm_count, types));
                }
                else if(curr_row<n-1)
                {
                    minm_count = Math.min(minm_count, replant(plot, curr_row+1, 0, n, m, curr_count, minm_count, types));
                }
                else
                {
                    return Math.min(curr_count, minm_count);
                }
                for(int k=0; k<26;k++)
                {
                    if(!left_up.contains(types[k]) && !right_down.contains(types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0; j<m; j++)
                            {
                                new_crops_mat[i][j] = plot[i][j];
                            }
                        }
                        new_crops_mat[curr_row][curr_col] = types[k];
                        if(curr_col<m-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row, curr_col+1, n, m, curr_count+1, minm_count, types));
                        }
                        else if(curr_row<n-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row+1, 0, n, m, curr_count+1, minm_count, types));
                        }
                        else
                        {
                            return Math.min(curr_count+1, minm_count);
                        }
                        break;
                    }
                }

            }
        }
        else
        {
            if(present_left_up)
            {
                for(int k=0; k<26;k++)
                {
                    if(!left_up.contains(types[k]) && !right_down.contains(types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                new_crops_mat[i][j] = plot[i][j];
                            }
                        }
                        new_crops_mat[curr_row][curr_col] = types[k];
                        if(curr_col<m-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row, curr_col+1, n, m, curr_count+1, minm_count, types));
                        }
                        else if(curr_row<n-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row+1, 0, n, m, curr_count+1, minm_count, types));
                        }
                        else
                        {
                            return Math.min(curr_count+1, minm_count);
                        }
                        break;
                    }
                }
            }
            else
            {
                if(curr_col<m-1)
                {
                    minm_count = Math.min(minm_count, replant(plot, curr_row, curr_col+1, n, m, curr_count, minm_count, types));
                }
                else if(curr_row<n-1)
                {
                    minm_count = Math.min(minm_count, replant(plot, curr_row+1, 0, n, m, curr_count, minm_count, types));
                }
                else
                {
                    return Math.min(curr_count, minm_count);
                }
            }
        }
        return minm_count;
    }

}
