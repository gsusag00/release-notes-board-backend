-- Applications

INSERT INTO applications (name) VALUES
                                    ('Customer Portal'),
                                    ('Mobile App'),
                                    ('Admin Dashboard'),
                                    ('Reporting Service'),
                                    ('API Gateway');

-- Items

INSERT INTO items (
    title,
    description,
    status,
    application_id
) VALUES
      (
          'Login Improvements',
          'Added remember me functionality',
          'DRAFT',
          1
      ),
      (
          'Password Reset',
          'Updated password reset flow',
          'REVIEW',
          1
      ),
      (
          'Release Notes View',
          'Added release notes page',
          'PUBLISHED',
          1
      ),
      (
          'Push Notifications',
          'Implemented notification support',
          'DRAFT',
          2
      ),
      (
          'Dark Mode',
          'Added dark theme support',
          'PUBLISHED',
          2
      ),
      (
          'Profile Editing',
          'Users can update profile information',
          'REVIEW',
          2
      ),
      (
          'User Management',
          'Create and disable users',
          'PUBLISHED',
          3
      ),
      (
          'Role Assignment',
          'Assign roles to users',
          'DRAFT',
          3
      ),
      (
          'Dashboard Widgets',
          'Added customizable widgets',
          'REVIEW',
          3
      ),
      (
          'Monthly Usage Report',
          'Generate monthly usage statistics',
          'PUBLISHED',
          4
      ),
      (
          'Export to Excel',
          'Export report data as xlsx',
          'DRAFT',
          4
      ),
      (
          'Performance Metrics',
          'Added service performance charts',
          'REVIEW',
          4
      ),
      (
          'Routing Optimization',
          'Improved request routing logic',
          'PUBLISHED',
          5
      ),
      (
          'Rate Limiting',
          'Added API rate limiting',
          'DRAFT',
          5
      ),
      (
          'Audit Logging',
          'Track gateway requests and responses',
          'REVIEW',
          5
      );